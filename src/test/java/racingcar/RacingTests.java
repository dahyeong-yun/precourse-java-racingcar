package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTests {
    @Test
    @DisplayName("레이싱은 입력한 이름의 수 만큼의 차를 갖는다")
    void racingHasCarWhat() {
        String userInput = "ploy,morph,morph,morph";
        String[] names = userInput.split(",");
        int numberOfNames = names.length;
        Racing racing = new Racing(numberOfNames);
        assertThat(racing.cars.size()).isEqualTo(numberOfNames);
    }

    @Test
    @DisplayName("이동거리가 가장 많은 차가 우승한다.")
    void longestDistanceIsWin() {
        // given
        String userInput = "ploy,morph1,morph2,morph3";
        String[] names = userInput.split(",");
        int numberOfNames = names.length;
        Racing racing = new Racing(numberOfNames);

        // when
        racing.cars.get(2).goForward();

        // then
        assertThat(racing.getWinnerName()).isEqualTo("morph2");
    }

}
