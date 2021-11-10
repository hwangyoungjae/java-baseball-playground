package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {
    @Test
    @DisplayName("랜덤 생성")
    void random() {
        System.out.println(RandomUtils.nextInt(1, 9));;
    }
}