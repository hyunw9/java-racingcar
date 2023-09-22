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
        int times = getTryTimes();

        gameView.printRacingStart();
        for (int i = 0; i < times; i++) {
            setProgress();
            GameView.showProgress(carList);
            System.out.println();
        }
        List<String> winners = new ArrayList<>(getWinners());
        gameView.showWinner(winners);
    }

    public String getCarNames() throws IOException {
        return input.readLine();
    }

    public int getTryTimes() throws IOException {
        String tryTimesStr = input.readLine();
        return Integer.parseInt(tryTimesStr);
    }

    public void setProgress() {
        carList.stream()
                .filter(car -> dice.validateMove())
                .forEach(Car::incrementCount);
    }

    public List<String> getWinners() {
        int maxCount = carList.stream().mapToInt(Car::getCount)
                .max()
                .orElse(0);
        return carList.stream()
                .filter(car -> car.getCount() == maxCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
