package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball ball;

    @BeforeEach
    void setUp() {
        ball = new Ball(1, 5);
    }

    @Test
    void strike() {
        Ball testBall = new Ball(1, 5);
        assertThat(ball.match(testBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball() {
        Ball testBall = new Ball(2, 5);
        assertThat(ball.match(testBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing() {
        Ball testBall = new Ball(2, 2);
        assertThat(ball.match(testBall)).isEqualTo(BallStatus.BALL);
    }
}
