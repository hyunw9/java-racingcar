import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NamesTest {

    @Test
    public void 이름은_쉼표로_구분한다(){
        //given
        String nameList = "티코, 아반떼";

        //when
        Names names = Names.createNames(nameList);

        //then
        Assertions.assertThat(names.getNames().toString()).contains("티코");
        Assertions.assertThat(names.getNames().toString()).contains("아반떼");
    }

    @Test
    public void 이름_중복_검사_실패(){
        //given
        String nameList = "티코, 티코";

        //when, then
        Assertions.assertThatThrownBy(() ->Names.createNames(nameList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 중복됩니다.");
    }
}