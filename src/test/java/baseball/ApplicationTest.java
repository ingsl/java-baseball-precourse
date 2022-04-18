package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.BaseballGameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private List<Integer> numbers;
    private BaseballGameService baseballGameService;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        baseballGameService = new BaseballGameService(numbers);

    }

    @ParameterizedTest
    @CsvSource(value = {"123:3 스트라이크", "256:1 볼", "456:낫싱", "125:2 스트라이크", "213:1 스트라이크2 볼"}, delimiter = ':')
    @DisplayName("입력값에 따른 게임 메시지 테스트")
    public void gameMessageTest(String input, String message) {
        baseballGameService.executeGame(input);
        assertThat(baseballGameService.getGameMessage()).isEqualTo(message);
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
