package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RacingTests {
    @Test
    @DisplayName("레이싱은 입력한 이름의 수 만큼의 차를 갖는다")
    void racingHasCarWhat() {
        String userInput = "ploy,morph,morph,morph";
        String[] names = userInput.split(",");
        int numberOfNames = names.length;
        Racing racing = Racing.setRacingCondition(userInput, 1);
        assertThat(racing.cars.size()).isEqualTo(numberOfNames);
    }

    @Test
    @DisplayName("이동거리가 가장 많은 차가 우승한다.")
    void longestDistanceIsWin() {
        // given
        String userInput = "ploy,morp1,morp2,morp3";
        Racing racing = Racing.setRacingCondition(userInput, 1);

        // when
        racing.cars.get(1).goForward();
        racing.cars.get(2).goForward();

        // then
        assertThat(racing.getPrintFormatWinnerName()).isEqualTo("morp1, morp2");
    }

    @Test
    @DisplayName("사용자가 입력한 만큼 랩을 돈다")
    void racingOneLap() {
        // given
        String userInput = "ploy,morh1,mrph2";
        Racing racing = Racing.setRacingCondition(userInput, 3);

        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 2, 3, 5, 7, 1, 7, 2, 4);
        String result = racing.start();
        assertThat(result).isEqualTo("ploy");
    }
}
;