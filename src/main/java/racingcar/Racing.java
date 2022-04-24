package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Racing {
    private final Cars cars;
    private final LapCount lapCount;
    private final List<String> winnerName =  new ArrayList<>();
    
    private Racing(CarNames carNames, LapCount lapCount) {
        this.lapCount = lapCount;
        this.cars = Cars.createCars(carNames);
    }
    
    public static Racing setRacingCondition(CarNames carNames, LapCount lapCount) {
        return new Racing(carNames, lapCount);
    }

    public String getPrintFormatWinnerName() {
        int maxDistance = getMaxDistance();

        for (Car car : cars.getCars()) {
            setWinnerName(maxDistance, car);
        }

        return String.join(", ", winnerName);
    }

    private void setWinnerName(int maxDistance, Car car) {
        if(maxDistance == car.getDistance()) {
            winnerName.add(car.getCarNameString());
        }
    }

    private int getMaxDistance() {
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

    private void lap() {
        for (Car car : cars.getCars()) {
            car.goOrNot(Randoms.pickNumberInRange(1, 10));
            car.printLabResult();
        }
        System.out.print("\n");
    }

    public void start() {
    	System.out.print("실행 결과\n");
        for (int i = 0; i < this.lapCount.getLapCount(); i++) {
            lap();
        }
    }
}
