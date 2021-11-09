package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항1, split")
    void splitTest() {
        String[] actual1 = "1,2".split(",");
        assertThat(actual1).contains("1", "2");
        String[] actual2 = "1".split(",");
        assertThat(actual2).containsExactly("1");
    }

    @Test
    @DisplayName("요구사항2, substring")
    void substringTest() {
        String value = "(1,2)";
        String actual = value.substring(1, value.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항3, charAt")
    void charAtTest() {
        String string = "abc";
        assertThat(string.charAt(0)).isEqualTo('a');
        assertThat(string.charAt(1)).isEqualTo('b');
        assertThat(string.charAt(2)).isEqualTo('c');
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    string.charAt(4);
                });
    }
}
