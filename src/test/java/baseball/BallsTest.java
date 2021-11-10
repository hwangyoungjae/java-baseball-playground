package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls answerBalls;

    @BeforeEach
    void setUp() {
        answerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void play_nothing() {
        PlayResult playresult = answerBalls.play(Arrays.asList(4, 5, 6));

    }

    @Test
    void nothing() {
        assertThat(answerBalls.match(new Ball(1, 5))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        assertThat(answerBalls.match(new Ball(3, 1))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        assertThat(answerBalls.match(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
    }
}