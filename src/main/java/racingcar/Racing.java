package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Racing {
    public List<Car> cars;
    private int lapCount;
    private List<String> winnerName =  new ArrayList<>();
    private String[] carNames;
    
    
    private Racing(String inputNames, int lapCount) {
    	carNames = inputNames.split(",");
        this.lapCount = lapCount;
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }
    
    public static Racing setRacingCondition(String inputNames, int lapCount) {
    	return new Racing(inputNames, lapCount);
    }

    public String getPrintFormatWinnerName() {
        int maxDistance = getMaxDistance();

        for (Car car : cars) {
            setWinnerName(maxDistance, car);
        }

        return String.join(", ", winnerName);
    }

    private void setWinnerName(int maxDistance, Car car) {
        if(maxDistance == car.getDistance()) {
            winnerName.add(car.getName());
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

    public void lap() {
        for (Car car : cars) {
            car.goOrNot(Randoms.pickNumberInRange(1, 10));
        }
    }

    public String start() {

        for (int i = 0; i < this.lapCount; i++) {
            lap();
        }

        return getPrintFormatWinnerName();
    }
}
