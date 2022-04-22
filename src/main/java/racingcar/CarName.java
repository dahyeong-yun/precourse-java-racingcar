package racingcar;

public class CarName {
    private final String carName;

    private CarName(String carName) {
        try {
            validateCarName(carName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
        this.carName = carName;
    }

    public static CarName createCarName(String inputName) {
        return new CarName(inputName);
    }

    private void validateCarName(String name) {
        if(name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public String getString() {
        return this.carName;
    }
}
