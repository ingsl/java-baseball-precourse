package domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballNumberGeneratorTest {
    BaseballNumberGenerator baseballNumberGenerator;

    @BeforeEach
    void setUp() {
        baseballNumberGenerator = new BaseballNumberGenerator();
    }

    @Test
    void baseballNumberGeneratorTest() {
        assertThat(baseballNumberGenerator.generateBaseballNumbers())
                .size()
                .isEqualTo(3);

        for (int i = 0; i < 3; i++) {
            assertThat(baseballNumberGenerator.generateBaseballNumbers()
                    .get(i))
                    .isBetween(1, 9);
        }
    }
}