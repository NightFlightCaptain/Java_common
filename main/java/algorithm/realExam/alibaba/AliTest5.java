package algorithm.realExam.alibaba;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2020/3/20 9:06
 */
public class AliTest5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] cards = new int[10];
        int total = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            cards[i] = scanner.nextInt();
            total += cards[i];
        }

        int[][] dp = new int[4][10];
        if (total == 1) {

            System.out.println(total);
        }
    }
}
