import java.util.HashSet;
import java.util.Set;

public class Car {

    private static final int INITIAL_START_COUNT = 1;

    private final Name name;
    private int count;

    public Car(Name name) {
        this.name = name;
        this.count = INITIAL_START_COUNT;
    }

    public static Car CreateCar(Name name){
        return new Car(name);
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
