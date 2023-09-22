import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final InputView inputView = new InputView();
    private final GameView gameView = new GameView();
    private final Dice dice = new Dice();
    private Names names;
    private Cars cars;

    public void startGame() throws IOException {

        gameView.askCarNames();

        Names nameList = Names.createNames(inputView.getNames());
        Cars cars = Cars.createCars(nameList);

        gameView.askTryCounts();
        int times = inputView.getTryTimes();

        gameView.showRacingStart();
        for (int i = 0; i < times; i++) {
            setProgress(cars);
            printCurrentProgress(cars);
            System.out.println();
        }
        List<String> winners = new ArrayList<>(getWinners());
        gameView.showWinner(winners);
    }

    public void setProgress(Cars cars) {
        cars.getCars()
                .stream()
                .filter(car -> dice.validateMove())
                .forEach(Car::incrementCount);
    }

    private void printCurrentProgress(Cars cars){
        for (Car car : cars.getCars()) {
            String progress = car.getProgress();
            gameView.showProgress(progress);
        }
    }
}
