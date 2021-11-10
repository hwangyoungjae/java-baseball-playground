package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void initialize() {
        Game game = new Game();
        assertThat(game).isInstanceOf(Game.class);
        assertThat(game.getStatus()).isEqualTo(GameStatus.PLAY);
    }
}