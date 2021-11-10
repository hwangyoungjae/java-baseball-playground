package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class GameMenuTest {
    @Test
    @DisplayName("GameMenu of")
    void of() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> {
                    GameMenu.of(0);
                });
    }
}