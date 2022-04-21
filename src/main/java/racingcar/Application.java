package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.print("경주할 자동차 이름을 입력하세요.\n");
        String userInput = Console.readLine();
        try {
            validateCarNames(userInput);    
        } catch (Exception e) {
            System.out.println(e);
        }
        
        String[] carNames = userInput.split(",");
        
        System.out.print("시도할 회수는 몇회인가요?\n");
        int lapTimes = Integer.parseInt(Console.readLine());
        System.out.print("\n");

        Racing racing = Racing.setRacingCondition(userInput, lapTimes);
        System.out.print("\n");
        System.out.print("최종 우승자는 "+racing.start()+" 입니다.");
    }

    private static void validateCarNames(String userInput) {
        String[] names = userInput.split(","); 
        for (String name : names) {
            if(name.length() > 5 || name.length() == 0) {
                throw new IllegalArgumentException("[ERROR] 이름");
            }
        }
    }
}
