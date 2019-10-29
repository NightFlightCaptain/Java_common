package algorithm.realExam.ByteDance2019Spring;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/2 8:59
 */
public class ByteDance2019Spring7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = scanner.nextInt();
        }

        int curEn = 0;
        for (int i = N - 1; i >= 0; i--) {
            curEn = (curEn + heights[i]) / 2 + (((curEn + heights[i]) & 1) == 1 ? 1 : 0);
        }
        System.out.println(curEn);
    }
}
