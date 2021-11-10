package baseball;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void stringToArrayList() {
        assertThat(Application.stringToArrayList("123")).isEqualTo(List.of(1, 2, 3));
    }
}