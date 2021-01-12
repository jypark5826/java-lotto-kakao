package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberSetTest {

    @Test
    @DisplayName("WinningNumber 생성 테스트")
    void createTest() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = Ball.of("7");

        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);

        assertThat(winningNumberSet).isEqualTo(new WinningNumberSet(winningLotto, bonusBall));
    }

    @Test
    @DisplayName("WinningNumber와 보너스볼이 중복되면 예외 발생")
    void duplicateTest() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = Ball.of("1");

        Throwable throwable = catchThrowable(() -> new WinningNumberSet(winningLotto, bonusBall));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
