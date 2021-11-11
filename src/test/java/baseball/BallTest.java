package baseball;

import baseball.exceptions.InvalidBallNumberError;
import baseball.exceptions.InvalidBallPositionError;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class BallTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void validationPosition(int pos) {
        assertThatExceptionOfType(InvalidBallPositionError.class)
                .isThrownBy(() -> new Ball(pos, 9));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void validationNumber(int n) {
        assertThatExceptionOfType(InvalidBallNumberError.class)
                .isThrownBy(() -> new Ball(1, n));
    }

    @Test
    void nothing() throws InvalidBallPositionError, InvalidBallNumberError {
        Ball ball = new Ball(1, 5);
        Ball userBall = new Ball(3, 9);
        assertThat(ball.match(userBall)).isEqualTo(BallMatchResult.NOTHING);
    }

    @Test
    void ball() throws InvalidBallPositionError, InvalidBallNumberError {
        Ball ball = new Ball(1, 5);
        Ball userBall = new Ball(3, 5);
        assertThat(ball.match(userBall)).isEqualTo(BallMatchResult.BALL);
    }

    @Test
    void strike() throws InvalidBallPositionError, InvalidBallNumberError {
        Ball ball = new Ball(1, 5);
        Ball userBall = new Ball(1, 5);
        assertThat(ball.match(userBall)).isEqualTo(BallMatchResult.STRIKE);
    }
}