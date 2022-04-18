package baseball;

import common.Const;
import domain.BaseballGameService;
import domain.Validation;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playGame(scanner);

        while (true) {
            String input = scanner.nextLine();
            if (!Validation.isInputGameStatus(input)) {
                System.out.println(Const.OPTION_EXCEPTION);
                continue;
            }

            if (Const.NEW_GAME.equals(input)) {
                playGame(scanner);
            }
            if (Const.QUIT.equals(input)) {
                break;
            }
        }
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        BaseballGameService baseBallGameService = new BaseballGameService();

        while (!baseBallGameService.isGameCompleted()) {
            try {
                System.out.print(Const.START_MESSAGE);
                baseBallGameService.executeGame(scanner.nextLine());
                System.out.println(baseBallGameService.getGameMessage());
            } catch (NumberFormatException ne) {
                System.out.println(ne.getMessage());
            }
        }
        System.out.println(Const.WINNING_MESSAGE);
        System.out.println(Const.NEW_GAME_OR_QUIT_MESSAGE);
    }
}
