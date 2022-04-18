package domain;

import common.Const;
import common.EnumData;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameService {
    private List<Integer> computerNumbers;
    private int strikeCount;
    private int ballCount;

    public BaseballGameService() {
        this.computerNumbers = getComputerNumbers();
    }

    public BaseballGameService(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public static List<Integer> userBaseballNumber(String numbers) {
        List<Integer> userBaseballNumbers = new ArrayList<>();
        for(int i =0; i < numbers.length(); i++) {
            int input = (Character.getNumericValue(numbers.charAt(i)));
            userBaseballNumbers.add(input);
        }
        return userBaseballNumbers;
    }

    public void executeGame(String input) {
        new Validation(input);
        initStatus();
        turn(input);
    }

    public boolean isGameCompleted() {
        return strikeCount == Const.MAX_STRIKE_COUNT;
    }

    public String getGameMessage() {
        String strikeMessage = strikeCount > 0 ? String.format("%d %s", strikeCount, EnumData.GameType.STRIKE.getType()) : "";
        String ballMessage = ballCount > 0 ? String.format("%d %s", ballCount, EnumData.GameType.BALL.getType()) : "";

        return strikeCount + ballCount > 0 ? String.format("%s%s", strikeMessage, ballMessage) : EnumData.GameType.NOTHING.getType();
    }

    //게임의 진행되는 Turn
    private void turn(String input) {
        for (int i = 0; i < input.length(); i++) {
            int number = input.charAt(i) - '0';
            if (computerNumbers.get(i) == number) {
                strikeCount++;
            } else if (computerNumbers.contains(number)) {
                ballCount++;
            }
        }
    }

    //컴퓨터의 Numbers 입력
    private List<Integer> getComputerNumbers() {
        List<Integer> computerNumbers = BaseballNumberGenerator.generateBaseballNumbers();
        return computerNumbers;
    }

    //상태 초기화.
    private void initStatus() {
        strikeCount = 0;
        ballCount = 0;
    }
}