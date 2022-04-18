package common;

public class Const {
    //Game Option
    public static final String NEW_GAME = "1";
    public static final String QUIT = "2";
    public static final String OPTION_EXCEPTION = "올바른 값을 입력해주세요(1:시작, 2:종료)";

    //Game Rule
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int BASEBALL_SIZE = 3;
    public static final int MAX_STRIKE_COUNT = 3;

    //Validation Message
    public static final String NUMBER_FORMAT_EXCEPTION = "입력값이 올바르지 않습니다. 숫자를 입력해주세요.";
    public static final String SIZE_EXCEPTION = "자리수가 올바르지 않습니다.";
    public static final String DUPLICATE_EXCEPTION = "중복된 값이 있습니다.";

    //Game Infomation Message
    public static final String START_MESSAGE = "야구 숫자를 입력하세요 : ";
    public static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NEW_GAME_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";




}
