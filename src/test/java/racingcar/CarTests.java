package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTests {

    @Test
    @DisplayName("차가 전진하면 이동거리가 1 증가한다")
    void forwardTest() {
        Car car = new Car();
        car.goForward();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
