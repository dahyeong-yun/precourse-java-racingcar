package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static final String ERROR_NAME_LENGTH_LIMIT = "[ERROR] 이름은 5글자 이하여야 합니다.";

    public static void start() {
        String userInput = getInputName();

        System.out.print("시도할 회수는 몇회인가요?\n");
        int lapTimes = Integer.parseInt(Console.readLine());
        System.out.print("\n");

        CarNames carNames = CarNames.getCarNamesFromInput(userInput);

        Racing racing = Racing.setRacingCondition(carNames, lapTimes);

        System.out.print("\n");
        System.out.print("최종 우승자: "+racing.start());
    }

    private static String getInputName() {
        System.out.print("경주할 자동차 이름을 입력하세요.\n");
        String userInput = Console.readLine();
        try {
            validateCarNames(userInput);
        } catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
        }
        return userInput;
    }

    private static void validateCarNames(String userInput) throws IllegalArgumentException {
        String[] names = userInput.split(",");
        for (String name : names) {
            if(name.length() > 5 || name.length() == 0) {
                throw new IllegalArgumentException(ERROR_NAME_LENGTH_LIMIT);
            }
        }
    }
}
