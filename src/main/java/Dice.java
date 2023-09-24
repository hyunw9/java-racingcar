import java.util.Random;

public class Dice {

    private static final int DELIMITER = 4;
    private static final int BOUND = 10;

    public Dice() {
        this.dice = random.nextInt(10);
    }

    public boolean validateMove() {
        Dice check = new Dice();
        return check.dice > DELIMITER;
    }
}
