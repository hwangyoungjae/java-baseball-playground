package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BallPositionTest {
    @Test
    void validation() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new BallPosition(0));
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new BallPosition(4));
    }

    @Test
    void getPosition() {
        BallPosition ballPosition = new BallPosition(1);
        assertThat(ballPosition.getPosition()).isEqualTo(1);
    }

    @Test
    void equalsSucc() {
        BallPosition b1 = new BallPosition(1);
        BallPosition b2 = new BallPosition(1);
        assertThat(b1.equals(b2)).isTrue();
    }

    @Test
    void equalsFail() {
        BallPosition b1 = new BallPosition(1);
        BallPosition b2 = new BallPosition(2);
        assertThat(b1.equals(b2)).isFalse();
    }
}