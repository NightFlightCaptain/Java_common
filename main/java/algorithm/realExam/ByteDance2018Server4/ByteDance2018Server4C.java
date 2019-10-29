package algorithm.realExam.ByteDance2018Server4;

import java.util.Scanner;

/**
 * 【房间跳跃】
 * <p>
 * 存在n+1个房间，每个房间依次为房间1 2 3...i，每个房间都存在一个传送门，i房间的传送门可以把人传送到房间pi(1<=pi<=i),现在路人甲从房间1开始出发(当前房间1即第一次访问)，每次移动他有两种移动策略：
 * A. 如果访问过当前房间 i 偶数次，那么下一次移动到房间i+1；
 * B. 如果访问过当前房间 i 奇数次，那么移动到房间pi；
 * 现在路人甲想知道移动到房间n+1一共需要多少次移动；
 * <p>
 * 输入描述:
 * 第一行包括一个数字n(30%数据1<=n<=100，100%数据 1<=n<=1000)，表示房间的数量，接下来一行存在n个数字 pi(1<=pi<=i), pi表示从房间i可以传送到房间pi。
 * <p>
 * 输出描述:
 * 输出一行数字，表示最终移动的次数，最终结果需要对1000000007 (10e9 + 7) 取模。
 * <p>
 * 输入例子1:
 * 2
 * 1 2
 * <p>
 * 输出例子1:
 * 4
 * <p>
 * 例子说明1:
 * 开始从房间1 只访问一次所以只能跳到p1即 房间1， 之后采用策略A跳到房间2，房间2这时访问了一次因此采用策略B跳到房间2，之后采用策略A跳到房间3，因此到达房间3需要 4 步操作。
 *
 * @author: 小栗旬
 * @Date: 2019/10/10 9:46
 */
public class ByteDance2018Server4C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] transfers = new int[n + 1];
        for (int i = 0; i < n; i++) {
            transfers[i] = scanner.nextInt() - 1;
        }

        long[] dp = new long[n + 1];

        for (int j = 1; j < n + 1; j++) {
            dp[j] = (2 * dp[j - 1] % 1000000007 - dp[transfers[j - 1]] + 2) % 1000000007;
        }
        System.out.println(dp[n] % 1000000007);
    }
}
