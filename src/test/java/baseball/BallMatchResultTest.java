package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallMatchResultTest {
    @Test
    void isNothing() {
        assertThat(BallMatchResult.NOTHING.isNothing()).isTrue();
    }

    @Test
    void isBall() {
        assertThat(BallMatchResult.BALL.isBall()).isTrue();
    }

    @Test
    void isStrike() {
        assertThat(BallMatchResult.STRIKE.isStrike()).isTrue();
    }
}