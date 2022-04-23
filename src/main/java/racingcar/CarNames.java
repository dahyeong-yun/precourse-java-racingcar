package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private final List<CarName> carNames;

    private CarNames(String userInput) {
        String[] inputNames = userInput.split(",");
        List<CarName> inputCarNames = new ArrayList<>();
        for(String name : inputNames) {
            inputCarNames.add(CarName.createCarName(name));
        }
        this.carNames = inputCarNames;
    }

    public static CarNames getCarNamesFromInput(String userInput) {
        return new CarNames(userInput);
    }

    public List<CarName> getCarNames() {
        return this.carNames;
    }
}
