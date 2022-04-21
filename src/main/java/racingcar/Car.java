package racingcar;

public class Car {
    private static final String LAB_RESULT_FORMAT = "%s : %s\n";
    private final String name;
    private int distance;

    public Car(String name) {
        try {
            validateCarName(name);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            throw e;
        }
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

    public void printLabResult() {
        System.out.print(String.format(LAB_RESULT_FORMAT, this.name, getProgressBar(this.distance)));
    }

    private String getProgressBar(int distance) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < distance; i++) {
            result.append("-");
        }
        return result.toString();
    }
}
