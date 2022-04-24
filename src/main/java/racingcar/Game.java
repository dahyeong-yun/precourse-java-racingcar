package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public static void play() {
        CarNames carNames = getInputName();
        LapCount lapTimes =  getInputLapCount();
        Racing racing = setRacing(carNames, lapTimes);
        String winnerNames = racing.start();
        printResult(winnerNames);
    }

    private static LapCount getInputLapCount() {
        System.out.print("시도할 회수는 몇회인가요?\n");
        String userInputCount = Console.readLine();

        return LapCount.createLapCount(userInputCount);
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

    private static Racing setRacing(CarNames carNames, LapCount lapTimes) {
        System.out.print("\n");
        return Racing.setRacingCondition(carNames, lapTimes);
    }

    private static void printResult(String winnerNames) {
        System.out.print("\n");
        System.out.printf("최종 우승자: %s", winnerNames);
    }
}
