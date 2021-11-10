package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallNumberTest {
    @Test
    void validation() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new BallNumber(0));
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new BallNumber(10));
    }

    @Test
    void getNumber() {
        BallNumber ballNumber = new BallNumber(1);
        assertThat(ballNumber.getNumber()).isEqualTo(1);
    }

    @Test
    void equalsSucc() {
        BallNumber b1 = new BallNumber(1);
        BallNumber b2 = new BallNumber(1);
        assertThat(b1.equals(b2)).isTrue();
    }

    @Test
    void equalsFail() {
        BallNumber b1 = new BallNumber(1);
        BallNumber b2 = new BallNumber(2);
        assertThat(b1.equals(b2)).isFalse();
    }
}