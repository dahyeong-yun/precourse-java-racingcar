package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Racing {
    public List<Car> cars;
    private final LapCount lapCount;
    private final List<String> winnerName =  new ArrayList<>();
    
    private Racing(CarNames carNames, LapCount lapCount) {
        this.lapCount = lapCount;
        cars = new ArrayList<>();
        for (CarName carName : carNames.getCarNames()) {
            cars.add(new Car(carName));
        }
    }
    
    public static Racing setRacingCondition(CarNames carNames, LapCount lapCount) {
        return new Racing(carNames, lapCount);
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
            winnerName.add(car.getCarNameString());
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
            car.printLabResult();
        }
        System.out.print("\n");
    }

    public String start() {
    	System.out.print("실행 결과\n");
        for (int i = 0; i < this.lapCount.getLapCount(); i++) {
            lap();
        }

        return getPrintFormatWinnerName();
    }
}
