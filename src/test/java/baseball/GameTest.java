package baseball;

import baseball.exceptions.InvalidError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Parser;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

    private Game game;
    private Balls answerBalls;

    @BeforeEach
    void setUp() throws InvalidError {
        answerBalls = Balls.ofArray(Arrays.asList(4, 5, 6));
        game = new Game(answerBalls);
    }

    @Test
    void test() throws InvalidError {
        Balls userBall = Balls.ofString("123");
        assertThat(game.pitching(userBall)).isInstanceOf(PlayResult.class);
    }

    @Test
    void done() throws InvalidError {
        game.pitching(Balls.ofString("456"));
        assertThat(game.getStatus()).isEqualTo(Game.GameStatus.DONE);
        assertThat(game.isDone()).isTrue();
    }

    @Test
    void doneException() throws InvalidError {
        game.pitching(Balls.ofString("456"));
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> game.pitching(Balls.ofString("123")));
    }
}