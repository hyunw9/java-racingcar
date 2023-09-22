import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(Names names){
        this.cars = new ArrayList<>(names.getNames()
                .stream()
                .map(Car::CreateCar)
                .collect(Collectors.toList()));
    }

    public static Cars createCars(Names names){
        return new Cars(names);
    }

    public List<Car> getCars() {
        return cars;
    }
    public List<String> getWinners(Cars cars) {
        int maxCount = cars.getCars()
                .stream().mapToInt(Car::getCount)
                .max()
                .orElse(0);
        return cars.getCars()
                .stream()
                .filter(car -> car.isWinner(maxCount))
                .map(Car::getName)
                .collect(Collectors.toList());

    }
}
