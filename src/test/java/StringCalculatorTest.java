import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    @Test
    @DisplayName("String->Integer 변환 성공")
    void strToIntSuccTest() {
        assertThat(StringCalculator.strToInt("1")).isEqualTo(1);
        assertThat(StringCalculator.strToInt("12")).isEqualTo(12);
        assertThat(StringCalculator.strToInt("-12")).isEqualTo(-12);
    }

    @Test
    @DisplayName("String->Integer 변환 실패")
    void strToIntFailTest() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            StringCalculator.strToInt("a");
        });
    }

    @Test
    void test() {
        String value = "2 + 3 * 4 / 2";
        Integer actual = StringCalculator.calc(value);
        assertThat(actual).isEqualTo(10);
    }
}