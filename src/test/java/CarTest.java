import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 처음_생성한_자동차의_상태(){
        //given
        Name name = Name.createName("first");

        //when
        Car car = Car.createCar(name);

        //then
        assertThat(car.getName()).isEqualTo("first");
        assertThat(car.getCount()).isEqualTo(1);
    }

    @Test
    public void 자동차의_거리를_증가시킨다(){
        //given
        Name name = Name.createName("car1");
        Car car = Car.createCar(name);

        //when
        car.incrementCount();

        //then
        assertThat(car.getCount()).isEqualTo(2);
    }
}