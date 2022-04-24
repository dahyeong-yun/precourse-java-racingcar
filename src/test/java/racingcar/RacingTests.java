package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingTests {

    @Test
    @DisplayName("이동거리가 가장 많은 차가 우승한다.")
    void longestDistanceIsWin() {
        // given
        String userInput = "ploy,morp1,morp2,morp3";
        CarNames carNames = CarNames.getCarNamesFromInput(userInput);

        Racing racing = Racing.setRacingCondition(carNames, LapCount.createLapCount("1"));

        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1,4,4,2);

        // when
        racing.start();
        mock.close();

        // then
        assertThat(racing.getPrintFormatWinnerName()).isEqualTo("morp1, morp2");

    }

    @Test
    @DisplayName("사용자가 입력한 만큼 랩을 돈다")
    void racingOneLap() {
        // given
        String userInput = "ploy,morh1,mrph2";
        CarNames carNames = CarNames.getCarNamesFromInput(userInput);

        Racing racing = Racing.setRacingCondition(carNames, LapCount.createLapCount("3"));

        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4, 2, 3, 5, 7, 1, 7, 2, 4);
        racing.start();
        String result = racing.getPrintFormatWinnerName();
        assertThat(result).isEqualTo("ploy");
    }
}
