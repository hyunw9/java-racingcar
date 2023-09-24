import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    public static final int MAX_NOT_EXIST = 0;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars(String nameString) {
        Names names = Names.createNames(nameString);
        List<Car> cars = new ArrayList<>(names.getNames()
                .stream()
                .map(Car::createCar)
                .collect(Collectors.toList()));
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> getWinners() {
        int maxCount = cars.stream()
                .mapToInt(Car::getCount)
                .max()
                .orElse(MAX_NOT_EXIST);
        return cars.stream()
                .filter(car -> car.isWinner(maxCount))
                .map(Car::getName)
                .collect(Collectors.toList());

    }
}
