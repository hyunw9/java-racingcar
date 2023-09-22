import java.util.HashSet;
import java.util.Set;

public class Car {

    private static Set<String> nameSet = new HashSet<>();
    private String name;
    private int count;

    public Car(Name name) {
        this.name = name;
        this.count = 1;
    }

    public static Car CreateCar(Name name){
        return new Car(name);
    }

    private void validateNameDuplication(String name) {
        if (!nameSet.add(name)) {
            throw new IllegalArgumentException("이름이 중복됩니다.");
        }
    }

    public int incrementCount() {
        return this.count++;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
