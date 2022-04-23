package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static void start() {
        CarNames carNames = getInputName();

        System.out.print("시도할 회수는 몇회인가요?\n");
        int lapTimes = Integer.parseInt(Console.readLine());
        System.out.print("\n");

        Racing racing = Racing.setRacingCondition(carNames, lapTimes);

        System.out.print("\n");
        System.out.print("최종 우승자: "+racing.start());
    }

    private static CarNames getInputName() {
        System.out.print("경주할 자동차 이름을 입력하세요.\n");
        String userInput = Console.readLine();
        try {
            return CarNames.getCarNamesFromInput(userInput);
        } catch (IllegalArgumentException e)  {
            System.out.println(e.getMessage());
            return getInputName();
        }
    }
}
