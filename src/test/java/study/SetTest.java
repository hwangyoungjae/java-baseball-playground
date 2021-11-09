package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항1, size")
    void sizeTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("요구사항2, contains")
    @ValueSource(ints = {1, 2, 3})
    void containsTest(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("요구사항3, not contains")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void notContainsTest(int input, String expected) {
        assertThat(String.valueOf(numbers.contains(input))).isEqualTo(expected);
    }
}
