import java.util.HashSet;
import java.util.Set;

public class Car {

    private static final int INITIAL_START_COUNT = 1;

    private final Name name;
    private int count;

    private Car(Name name, int count) {
        this.name = name;
        this.count = count;
    }

    public static Car createCar(Name name) {
        return new Car(name,INITIAL_START_COUNT);
    }

    public void incrementCount() {
         this.count++;
    }

    public String getName() {
        return name.toString();
    }

    public int getCount() {
        return count;
    }

    public String getProgress(){
        return name + ": " + "-".repeat(count);
    }

    public boolean isWinner(int count){
    public boolean isWinner(int count) {
        return this.count == count;
    }
}
