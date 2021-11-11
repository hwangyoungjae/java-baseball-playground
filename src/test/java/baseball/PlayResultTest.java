package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlayResultTest {
    @Test
    void getBall() {
        PlayResult result = new PlayResult();
        result.evaluation(BallMatchResult.BALL);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void getStrike() {
        PlayResult result = new PlayResult();
        result.evaluation(BallMatchResult.STRIKE);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void isEnded() {
        PlayResult result = new PlayResult();
        for (int i = 0; i < 3; i++) {
            result.evaluation(BallMatchResult.STRIKE);
        }
        assertThat(result.isEnded()).isTrue();
    }
}