package receipts.utils;

import java.util.Random;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Utility Class");
    }

    public static String getAmountStr() {
        Random rand = new Random();
        int randInt = rand.nextInt(1, 100);
        if(randInt % 3 == 0) {
            return "총합";
        } else if (randInt % 3 == 1) {
            return "총 가격";
        } else {
            return "총계";
        }
    }
}
