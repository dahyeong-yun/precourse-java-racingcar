package racingcar;

public class Distance {
    public static final int INITIATE_DISTANCE = 0;
    public static final int FORWARD_UNIT = 1;
    private final int intDistance;

    private Distance(int intDistance) {
        this.intDistance = intDistance;
    }

    public static Distance createDistance() {
        return new Distance(INITIATE_DISTANCE);
    }

    public int getCurrentDistance() {
        return intDistance;
    }

    public Distance goForward() {
        return new Distance(this.intDistance + FORWARD_UNIT);
    }
}
