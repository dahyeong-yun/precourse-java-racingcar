package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public List<Car> cars;

    public Racing(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public String getWinnerName() {
        StringBuffer winnerName = new StringBuffer();
        int maxDistance = getMaxDistance();

        for (Car car : cars) {
            setWinnerName(winnerName, maxDistance, car);
        }

        return winnerName.toString();
    }

    private void setWinnerName(StringBuffer winnerName, int maxDistance, Car car) {
        if(maxDistance == car.getDistance()) {
            winnerName.append(car.getName());
        }
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = setMaxDistance(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private int setMaxDistance(int maxDistance, int currentCarDistance) {
        if(maxDistance < currentCarDistance) {
            maxDistance = currentCarDistance;
        }
        return maxDistance;
    }
}
