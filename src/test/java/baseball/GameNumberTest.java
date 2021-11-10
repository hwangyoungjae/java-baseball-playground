package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameNumberTest {
    @Test
    void validation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new GameNumber("1234"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new GameNumber("123a"));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new GameNumber("113"));
    }

    @Test
    void match() {
        GameNumber gamenumber = new GameNumber("123");
        assertThat(gamenumber.match(new GameNumber("456"))).isEqualTo(new int[]{0, 0});
        assertThat(gamenumber.match(new GameNumber("451"))).isEqualTo(new int[]{1, 0});
        assertThat(gamenumber.match(new GameNumber("156"))).isEqualTo(new int[]{0, 1});
        assertThat(gamenumber.match(new GameNumber("152"))).isEqualTo(new int[]{1, 1});
        assertThat(gamenumber.match(new GameNumber("123"))).isEqualTo(new int[]{0, 3});
    }
}