package algorithm.realExam.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2020/3/19 19:27
 */
public class MeiTuan2020Spring3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int m = scanner.nextInt();

        int p = scanner.nextInt();
        int q = scanner.nextInt();
        int[] sonWorks = new int[k];
        for (int i = 0; i < k; i++) {
            sonWorks[i] = scanner.nextInt();
        }
        Arrays.sort(sonWorks);

        int[][] dp = new int[k + 1][n + 1];
        int[][] rest = new int[k + 1][n + 1];
        for (int i = 0; i < k + 1; i++) {
            rest[i][0] = m;
        }
        Arrays.fill(rest[0], m);
        int res = 0;
        rest[0][0] = m;
        for (int i = 1; i <= k; i++) {
            // 该子任务所需事件
            int workTime = sonWorks[i - 1];
            // 大任务
            for (int j = 1; j <= n; j++) {
                // 上一个子任务的剩余时间
                if (workTime <= rest[i - 1][j]) {
                    rest[i][j] = rest[i - 1][j] - workTime;
                    dp[i][j] = dp[i - 1][j] + p;
                    if (i == k) {
                        dp[i][j] += q;
                    }
                }
                if (workTime <= rest[i][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + p);
                    rest[i][j] = rest[i][j - 1] - workTime;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        System.out.println(res);
    }


}
