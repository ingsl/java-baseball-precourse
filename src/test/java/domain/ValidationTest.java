package domain;

import common.Const;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidationTest {
    BaseballGameService baseballGameService;

    @BeforeEach
    void setUp() {
        baseballGameService = new BaseballGameService();
    }

    @Test
    public void inputNumberFormatExceptionTest() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            String input = "12a";
            baseballGameService.executeGame(input);
        }).withMessageMatching(Const.NUMBER_FORMAT_EXCEPTION);
    }

    @Test
    public void inputIllegalArgumentExceptionTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            String input = "122";
            baseballGameService.executeGame(input);
        }).withMessageMatching(Const.DUPLICATE_EXCEPTION);

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            String input = "12";
            baseballGameService.executeGame(input);
        }).withMessageMatching(Const.SIZE_EXCEPTION);
    }
}