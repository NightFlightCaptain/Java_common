package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【龙与地下城游戏问题】
 * <p>
 * 题目描述
 * 给定一个二维数组map，含义是一张地图，例如，如下矩阵
 * -2 -3 3
 * -5 -10 1
 * 0 30 -5​
 * <p>
 * 游戏的规则如下:
 * 1）骑士从左上角出发，每次只能向右或向下走，最后到达右下角见到公主。
 * 2）地图中每个位置的值代表骑士要遭遇的事情。如果是负数，说明此处有怪兽，要让骑士损失血量。如果是非负数，代表此处有血瓶，能让骑士回血。
 * 3）骑士从左上角到右下角的过程中，走到任何一个位置时，血量都不能少于1。为了保证骑土能见到公主，初始血量至少是多少?
 * 根据map,输出初始血量。
 * <p>
 * 输入描述:
 * 第一行两个正整数n，m (1≤n,m≤10^3)，接下来n行，每行m个整数，代表map_ij(−10^3<=map_ij<=10^3)
 * <p>
 * 输出描述:
 * 输出一个整数，表示答案。
 * 示例1
 * 输入
 * 3 3
 * -2 -3 3
 * -5 -10 1
 * 0 30 -5
 * 输出
 * 7
 * <p>
 * 示例2
 * 输入
 * 2 2
 * 1 1
 * 1 1
 * 输出
 * 1
 * 备注:
 * 时间复杂度O(n∗m),额外空间复杂度O(min(n,m))
 *
 * @author: 小栗旬
 * @Date: 2019/10/25 13:55
 */
public class CodeInterviewGuide45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int shortLength = n > m ? m : n;
        int longLength = n > m ? n : m;
        int[][] map = new int[longLength][shortLength];
        if (n >= m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[j][i] = scanner.nextInt();
                }
            }
        }

        int[] dp = new int[shortLength + 1];
//        dp[shortLength - 1] = map[longLength - 1][shortLength - 1] >= 0 ? 1 : 1 - map[longLength - 1][shortLength - 1];
        for (int i = 0; i < shortLength + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[shortLength - 1] = 1;
        for (int i = longLength - 1; i >= 0; i--) {
            for (int j = shortLength - 1; j >= 0; j--) {
                if (map[i][j] >= dp[j + 1] || map[i][j] >= dp[j]) {
                    dp[j] = 1;
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) - map[i][j];
                }
            }
        }
        System.out.println(dp[0]);


    }
}
