import java.util.Random;

public class Dice {

    public static final int DELIMITER = 4;
    Random random = new Random();
    private int dice;

    public Dice() {
        this.dice = random.nextInt(10);
    }

    public boolean validateMove() {
        Dice check = new Dice();
        return check.dice > DELIMITER;
    }
}
