package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if(name.length() > 5 || name.length() == 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public void goForward() {
        this.distance++;
    }

    public int getDistance() {
        return this.distance;
    }

    public void goOrNot(int flag) {
        if(flag >= 4) {
            goForward();
        }
    }

    public String getName() {
        return this.name;
    }
}
