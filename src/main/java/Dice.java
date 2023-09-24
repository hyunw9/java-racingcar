import java.util.Random;

public class Dice {

    private static final int DELIMITER = 4;
    private static final int BOUND = 10;

    private final int number;

    private Dice(int random) {
        this.number = random;
    }

    public static Dice createRandomDice(){
        int random = new Random().nextInt(BOUND);
        return new Dice(random);
    }

    public boolean validateMove() {
        return number > DELIMITER;
    }
}
