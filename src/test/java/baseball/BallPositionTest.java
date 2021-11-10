package baseball;

import baseball.exceptions.InvalidArgumentError;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class BallPositionTest {
    @Test
    void validation() {
        assertThatExceptionOfType(InvalidArgumentError.class)
                .isThrownBy(() -> new BallPosition(0));
        assertThatExceptionOfType(InvalidArgumentError.class)
                .isThrownBy(() -> new BallPosition(4));
    }

    @Test
    void getPosition() throws InvalidArgumentError {
        BallPosition ballPosition = new BallPosition(1);
        assertThat(ballPosition.getPosition()).isEqualTo(1);
    }

    @Test
    void equalsSucc() throws InvalidArgumentError {
        BallPosition b1 = new BallPosition(1);
        BallPosition b2 = new BallPosition(1);
        assertThat(b1.equals(b2)).isTrue();
    }

    @Test
    void equalsFail() throws InvalidArgumentError {
        BallPosition b1 = new BallPosition(1);
        BallPosition b2 = new BallPosition(2);
        assertThat(b1.equals(b2)).isFalse();
    }
}