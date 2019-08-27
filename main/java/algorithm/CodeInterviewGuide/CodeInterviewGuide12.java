package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/27 14:32
 * <p>
 * 题目描述
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，
 * 代表要找的钱数，求组成aim的最少货币数。
 * 输入描述:
 * 输入包括两行，第一行两个整数n（0<=n<=1000）代表数组长度和aim（0<=aim<=5000），第二行n个不重复的正整数，
 * 代表arr( 1<=arri<=10^9)
 * <p>
 * 输出描述:
 * 输出一个整数，表示组成aim的最小货币数，无解时输出-1.
 * <p>
 * 示例1
 * 输入
 * 3 20
 * 5 2 3
 * 输出
 * 4
 * 说明
 * 20=5*4
 * <p>
 * 示例2
 * 输入
 * 3 0
 * 5 2 3
 * 输出
 * 0
 * <p>
 * 示例3
 * 输入
 * 2 2
 * 3 5
 * 输出
 * -1
 * <p>
 * 备注:
 * 时间复杂度O(n*aim)，空间复杂度O(aim)。
 */
public class CodeInterviewGuide12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int aim = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int[] dp = new int[aim + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= aim; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i && dp[i-coins[j]]!=-1) {
                    if (dp[i]==-1){
                        dp[i]=dp[i-coins[j]]+1;
                    }else {
                        dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                    }
                }
            }
        }
        System.out.println(dp[aim]);
    }
}
