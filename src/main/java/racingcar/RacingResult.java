package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<String> winnerNames;

    private RacingResult(Racing racing) {
        this.winnerNames = getWinnerNameList(racing.getCars());
    }

    public static RacingResult generateResult(Racing racing) {
        return new RacingResult(racing);
    }

    public List<String> getWinnerNameList(Cars cars) {
        int maxDistance = getMaxDistance(cars);
        List<String> winnerList = new ArrayList<>();

        for (Car car : cars.getCars()) {
            setWinnerName(maxDistance, car, winnerList);
        }
        return winnerList;
    }

    private void setWinnerName(int maxDistance, Car car, List<String> winnerList) {
        if(maxDistance == car.getDistance()) {
            winnerList.add(car.getCarNameString());
        }
    }

    private int getMaxDistance(Cars cars) {
        int maxDistance = 0;
        for (Car car : cars.getCars()) {
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

    public void printResult() {
        System.out.print("\n");
        System.out.printf("최종 우승자: %s", String.join(", ", this.winnerNames));
    }
}
