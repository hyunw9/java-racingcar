import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    public void 이름_길이_검증_실패() {
        //given
        String example1 = "asdfg1";

        //when, then
        Assertions.assertThatThrownBy(() -> Name.createName(example1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름 길이가 5를 초과합니다.");
    }

    @Test
    public void 이름_길이_검증_성공() {
        //given
        String example1 = "test";

        //when
        Name name = Name.createName(example1);

        //then
        assertThat(name.toString()).isEqualTo("test");
    }
}
