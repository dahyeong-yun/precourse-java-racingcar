package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public List<Car> cars;

    public Racing(int numberOfCar) {
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car("name"));
        }
    }

    public String getWinnerName() {
        StringBuffer winnerName = new StringBuffer();
        int maxDistance = 0;

        for (Car car : cars) {
            if(maxDistance < car.getDistance()) {
                winnerName.append(car.getName());
            }
        }

        return "morph2";
    }
}
