package algorithm.realExam.ByteDance2019Spring;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/1 17:27
 */
public class ByteDance2019Spring3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");

        int[] cards = new int[9];
        for (String string : strings) {
            cards[Integer.valueOf(string)-1]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (cards[i] < 4) {
                cards[i]++;

                if (hu(cards, 14)){
                    stringBuilder.append(" ").append(i+1);
                }
                cards[i]--;
            }
        }
        if (stringBuilder.length() == 0){
            System.out.println(0);
        }else {
            System.out.println(stringBuilder.substring(1));
        }

    }

    private static boolean hu(int[] cards, int length) {
        if (length == 0) {
            return true;
        }

        if (length % 3 == 0) {
            /* 刻子的情况*/
            for (int i = 0; i < 9; i++) {
                if (cards[i] >= 3) {
                    int[] newCards = cards.clone();
                    newCards[i] -= 3;
                    if (hu(newCards, length - 3)) {
                        return true;
                    }
                }

                if (i < 7 && cards[i] > 0 && cards[i + 1] > 0 && cards[i + 2] > 0) {
                    int[] newCards = cards.clone();
                    newCards[i]--;
                    newCards[i + 1]--;
                    newCards[i + 2]--;
                    if (hu(newCards, length - 3)) {
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < 9; i++) {
                if (cards[i] >= 2) {
                    int[] newCards = cards.clone();
                    newCards[i] -= 2;
                    if (hu(newCards, length - 2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
