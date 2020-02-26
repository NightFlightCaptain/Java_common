package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【完全平方数】
 * <p>
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/15 16:38
 */
public class LeetCode279 {
    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int squareIndex = 1;
        int square;
        while ((square = squareIndex * squareIndex++) <= n) {
            for (int i = 1; i <= n; i++) {
                if (square <= i) {
                    dp[i] = Math.min(dp[i - square] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode279 solution = new LeetCode279();
        System.out.println(solution.numSquares(12));
        System.out.println(solution.numSquares(13));
        System.out.println(solution.numSquares(566131));
    }
}
