package racingcar;

public class Car {
    private int distance;

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
}
