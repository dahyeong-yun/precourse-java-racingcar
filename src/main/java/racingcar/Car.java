package racingcar;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
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
