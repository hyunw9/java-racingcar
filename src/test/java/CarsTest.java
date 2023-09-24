import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    public void 자동차들_생성_성공(){
        //given
        String carNames = "포비,나나,포";

        //when
        Cars cars = Cars.createCars(carNames);
        List<Car> carList = cars.getCars();

        //then
        assertThat(carList.get(0).getName()).contains("포비");
        assertThat(carList.get(1).getName()).contains("나나");
        assertThat(carList.get(2).getName()).contains("포");
    }

    @Test
    public void 승자_1명_출력(){
        //given
        String carNames = "포비,나나,포";
        Cars cars =Cars.createCars(carNames);
        List<String> winner = new ArrayList<>();
        List<Car> carList = cars.getCars();

        //when
        winner.add("포비");
        carList.get(0).incrementCount();

        //then
        assertThat(cars.getWinners().toString()).isEqualTo(winner.toString());
    }

    @Test
    public void 승자_다수_출력(){
        //given
        String carNames = "포비,나나,포";
        Cars cars =Cars.createCars(carNames);
        List<String> winner = new ArrayList<>();
        List<Car> carList = cars.getCars();

        //when
        winner.add("포비");
        winner.add("나나");
        carList.get(0).incrementCount();
        carList.get(1).incrementCount();

        //then
        assertThat(cars.getWinners().toString()).isEqualTo(winner.toString());
    }
}
