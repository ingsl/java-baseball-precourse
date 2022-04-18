package domain;

import common.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseballNumberGenerator {
    public static List<Integer> generateBaseballNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();

        while(baseballNumbers.size() < Const.BASEBALL_SIZE) {
            addBaseballNumber(baseballNumbers);
        }
        return baseballNumbers;
    }

    private static void addBaseballNumber(List<Integer> baseballNumbers) {
        int randomNumber = generateRandomNumber();
        if (baseballNumbers.contains(randomNumber)) {
            return;
        }
        baseballNumbers.add(randomNumber);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(Const.MAX_NUM) + Const.MIN_NUM;
    }
}
