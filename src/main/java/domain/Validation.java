package domain;

import common.Const;

import java.util.HashSet;
import java.util.Set;

public class Validation {
    public Validation(String input) {
        isNumberValid(input);
        isSizeValid(input);
        isDuplicate(input);
    }

    public static boolean isInputGameStatus(String input) {
        return Const.NEW_GAME.equals(input) || Const.QUIT.equals(input);
    }

    public static void isDuplicate(String input) {
        Set<Character> setTemp = new HashSet<>();
        for (Character character : input.toCharArray()) {
            setTemp.add(character);
        }
        if(setTemp.size() !=  input.length()) {
            throw new IllegalArgumentException(Const.DUPLICATE_EXCEPTION);
        }
    }

    public static void isNumberValid(String input) {
        String regExp = "^[1-9]+$";
        if(!input.matches(regExp)) {
            throw new NumberFormatException(Const.NUMBER_FORMAT_EXCEPTION);
        }
    }

    private void isSizeValid(String input) {
        if(input.length() != Const.BASEBALL_SIZE) {
            throw new IllegalArgumentException(Const.SIZE_EXCEPTION);
        }
    }
}
