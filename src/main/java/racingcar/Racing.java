package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    private final Cars cars;
    private final LapCount lapCount;
    
    private Racing(CarNames carNames, LapCount lapCount) {
        this.lapCount = lapCount;
        this.cars = Cars.createCars(carNames);
    }
    
    public static Racing setRacingCondition(CarNames carNames, LapCount lapCount) {
        return new Racing(carNames, lapCount);
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

    public Cars getCars() {
        return this.cars;
    }
}
