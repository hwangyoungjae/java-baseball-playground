package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball answerBall;

    @BeforeEach
    void setUp() {
        answerBall = new Ball(1, 5);
    }

    @Test
    void equalsSucc() {
        assertThat(answerBall.equals(new Ball(1, 5))).isTrue();
    }

    @Test
    void equalsFail() {
        assertThat(answerBall.equals(new Ball(1, 4))).isFalse();
        assertThat(answerBall.equals(new Ball(2, 5))).isFalse();
        assertThat(answerBall.equals(new Ball(3, 3))).isFalse();
    }

    @Test
    void nothing() {
        Ball userBall = new Ball(2, 6);
        assertThat(answerBall.match(userBall)).isEqualTo(BallMatchResult.NOTHING);
    }

    @Test
    void ball() {
        Ball userBall = new Ball(2, 5);
        assertThat(answerBall.match(userBall)).isEqualTo(BallMatchResult.BALL);
    }

    @Test
    void strike() {
        Ball userBall = new Ball(1, 5);
        assertThat(answerBall.match(userBall)).isEqualTo(BallMatchResult.STRIKE);
    }
}
