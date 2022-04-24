package racingcar;

public class Car {
    private static final String LAB_RESULT_FORMAT = "%s : %s\n";

    private final CarName carName;
    private Distance distance;

    private Car(CarName carName) {
        this.carName = carName;
        this.distance = Distance.createDistance();
    }

    public static Car createCar(CarName carName) {
        return new Car(carName);
    }

    public void goForward() {
        distance = distance.goForward();
    }

    public int getDistance() {
        return this.distance.getCurrentDistance();
    }

    public void goOrNot(int flag) {
        if(flag >= 4) {
            goForward();
        }
    }

    public String getCarNameString() {
        return this.carName.getString();
    }

    public void printLabResult() {
        System.out.printf(LAB_RESULT_FORMAT, this.carName.getString(), getProgressBar(this.distance.getCurrentDistance()));
    }

    private String getProgressBar(int distance) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
