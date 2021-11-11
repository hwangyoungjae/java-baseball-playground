package baseball;

import baseball.exceptions.InvalidBallPositionError;
import baseball.exceptions.InvalidBallsDuplicatedError;
import baseball.exceptions.InvalidError;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BallsTest {
    @Test
    void ofStringArgumentValidation() {
        assertThatExceptionOfType(InvalidBallPositionError.class)
                .isThrownBy(() -> Balls.ofString("1"));
        assertThatExceptionOfType(InvalidBallPositionError.class)
                .isThrownBy(() -> Balls.ofString("12"));
        assertThatExceptionOfType(InvalidBallPositionError.class)
                .isThrownBy(() -> Balls.ofString("1456"));
    }

    @Test
    void ofStringArgumentDuplicated() {
        assertThatExceptionOfType(InvalidBallsDuplicatedError.class)
                .isThrownBy(() -> Balls.ofString("112"));
    }

    @Test
    void ofStringSuccessful() throws InvalidError {
        assertThat(Balls.ofString("123")).isInstanceOf(Balls.class);
    }

    @Test
    void ofArrayValidation() {
        assertThatExceptionOfType(InvalidBallPositionError.class)
                .isThrownBy(() -> Balls.ofArray(Arrays.asList(1, 2)));
        assertThatExceptionOfType(InvalidBallPositionError.class)
                .isThrownBy(() -> Balls.ofArray(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    void ofArrayArgumentDuplicated() {
        assertThatExceptionOfType(InvalidBallsDuplicatedError.class)
                .isThrownBy(() -> Balls.ofArray(Arrays.asList(1, 1, 2)));
    }

    @Test
    void ofArraySuccessful() throws InvalidError {
        assertThat(Balls.ofArray(Arrays.asList(1, 2, 3))).isInstanceOf(Balls.class);
    }

    @Test
    void nothing() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Ball userBall = new Ball(1, 5);
        assertThat(balls.match(userBall)).isEqualTo(BallMatchResult.NOTHING);
    }

    @Test
    void ball() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Ball userBall = new Ball(1, 3);
        assertThat(balls.match(userBall)).isEqualTo(BallMatchResult.BALL);
    }

    @Test
    void strike() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Ball userBall = new Ball(1, 1);
        assertThat(balls.match(userBall)).isEqualTo(BallMatchResult.STRIKE);
    }

    @Test
    void playNothing() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Balls userBalls = Balls.ofString("456");
        assertThat(balls.play(userBalls).isNothing()).isTrue();
    }

    @Test
    void play1B() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Balls userBalls = Balls.ofString("451");
        PlayResult result = balls.play(userBalls);
        assertThat(result.getBall() == 1 && result.getStrike() == 0).isTrue();
    }

    @Test
    void play1S() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Balls userBalls = Balls.ofString("156");
        PlayResult result = balls.play(userBalls);
        assertThat(result.getBall() == 0 && result.getStrike() == 1).isTrue();
    }

    @Test
    void play1B1S() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Balls userBalls = Balls.ofString("134");
        PlayResult result = balls.play(userBalls);
        assertThat(result.getBall() == 1 && result.getStrike() == 1).isTrue();
    }

    @Test
    void play3S() throws InvalidError {
        Balls balls = Balls.ofString("123");
        Balls userBalls = Balls.ofString("123");
        PlayResult result = balls.play(userBalls);
        assertThat(result.getBall() == 0 && result.getStrike() == Ball.MAX_POSITION).isTrue();
        assertThat(result.isEnded()).isTrue();
    }
}
