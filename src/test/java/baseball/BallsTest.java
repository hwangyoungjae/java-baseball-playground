package baseball;

import baseball.exceptions.InvalidArgumentError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BallsTest {

    private Balls answerBalls;

    @Test
    void duplicatedNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Balls.numberOf(Arrays.asList(1, 1, 1)));
    }

    @BeforeEach
    void setUp() throws InvalidArgumentError {
        answerBalls = Balls.numberOf(Arrays.asList(4, 5, 6));
    }

    @Test
    void numberOf() throws InvalidArgumentError {
        Ball b1 = answerBalls.balls.get(0);
        Ball b2 = answerBalls.balls.get(1);
        Ball b3 = answerBalls.balls.get(2);
        assertThat(b1.equals(new Ball(1, 4))).isTrue();
        assertThat(b2.equals(new Ball(2, 5))).isTrue();
        assertThat(b3.equals(new Ball(3, 6))).isTrue();
    }

    @Test
    void nothing() throws InvalidArgumentError {
        assertThat(answerBalls.match(new Ball(1, 9))).isEqualTo(BallMatchResult.NOTHING);
    }

    @Test
    void ball() throws InvalidArgumentError {
        assertThat(answerBalls.match(new Ball(1, 6))).isEqualTo(BallMatchResult.BALL);
    }

    @Test
    void strike() throws InvalidArgumentError {
        assertThat(answerBalls.match(new Ball(1, 4))).isEqualTo(BallMatchResult.STRIKE);
    }

    @Test
    void playNothing() throws InvalidArgumentError {
        Balls userBalls = Balls.numberOf(Arrays.asList(7, 8, 9));
        PlayResult playResult = answerBalls.play(userBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    void play1Ball() throws InvalidArgumentError {
        Balls userBalls = Balls.numberOf(Arrays.asList(7, 8, 4));
        PlayResult playResult = answerBalls.play(userBalls);
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    void play3Ball() throws InvalidArgumentError {
        Balls userBalls = Balls.numberOf(Arrays.asList(5, 6, 4));
        PlayResult playResult = answerBalls.play(userBalls);
        assertThat(playResult.getBall()).isEqualTo(3);
        assertThat(playResult.getStrike()).isEqualTo(0);
    }

    @Test
    void play1Ball1Strike() throws InvalidArgumentError {
        Balls userBalls = Balls.numberOf(Arrays.asList(4, 6, 9));
        PlayResult playResult = answerBalls.play(userBalls);
        assertThat(playResult.getBall()).isEqualTo(1);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    void play1Strike() throws InvalidArgumentError {
        Balls userBalls = Balls.numberOf(Arrays.asList(4, 8, 9));
        PlayResult playResult = answerBalls.play(userBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(1);
    }

    @Test
    void play3Strike() throws InvalidArgumentError {
        Balls userBalls = Balls.numberOf(Arrays.asList(4, 5, 6));
        PlayResult playResult = answerBalls.play(userBalls);
        assertThat(playResult.getBall()).isEqualTo(0);
        assertThat(playResult.getStrike()).isEqualTo(3);
        assertThat(playResult.isEnded()).isTrue();
    }
}
