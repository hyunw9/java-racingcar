import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final InputView inputView = new InputView();
    private final GameView gameView = new GameView();

    private Cars cars;

    public void startGame() throws IOException {

        gameView.askCarNames();

        String nameInput = inputView.getNames();
        cars = Cars.createCars(nameInput);

        gameView.askTryCounts();
        int times = inputView.getTryTimes();

        gameView.showRacingStart();
        for (int i = 0; i < times; i++) {
            setProgress();
            printCurrentProgress();
            System.out.println();
        }
        List<String> winners = new ArrayList<>(cars.getWinners());
        gameView.showWinner(winners);
    }

    public void setProgress() {
        cars.getCars()
                .stream()
                .filter(car -> Dice.createRandomDice()
                        .validateMove())
                .forEach(Car::incrementCount);
    }

    private void printCurrentProgress(){
        for (Car car : cars.getCars()) {
            String progress = car.getName() + ": " + "-".repeat(car.getCount());
            gameView.showProgress(progress);
        }
    }
}
