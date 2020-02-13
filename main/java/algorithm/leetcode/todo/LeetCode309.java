package algorithm.leetcode.todo;

/**
 * 【最佳买卖股票时机含冷冻期】
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/2/13 21:39
 */
public class LeetCode309 {
    public int maxProfit(int[] prices) {
        return maxProfit2(prices);
//        int length = prices.length;
//        if (length <= 1) {
//            return 0;
//        }
//        int maxProfit = 0;
//        int[] dp = new int[length];
//        for (int i = 1; i < length; i++) {
//            for (int j = 0; j < i; j++) {
//
//                if (j < 2) {
//                    dp[i] = Math.max(dp[i], (prices[i] > prices[j] ? prices[i] - prices[j] : 0));
//                    dp[i] = Math.max(dp[i], dp[i - 1]);
//                } else {
//                    dp[i] = Math.max(dp[i],
//                            dp[j - 2] + (prices[i] > prices[j] ? prices[i] - prices[j] : 0));
//                    dp[i] = Math.max(dp[i], dp[i - 1]);
//                }
//            }
//            maxProfit = dp[i] > maxProfit ? dp[i] : maxProfit;
//        }
//        return maxProfit;
    }

    private int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        // 第一个维度表示天数，第二个维度表示是否持有股票,0表示不持有，1表示持有
        int[][] dp = new int[length][2];
        dp[0][1] = -prices[0];
        dp[1][0] = prices[1] > prices[0] ? prices[1] - prices[0] : 0;
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        for (int i = 2; i < length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        LeetCode309 solution = new LeetCode309();
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 0, 2}) == 3);
        System.out.println(solution.maxProfit(new int[]{2, 3, 4, 0, 2, 2, 5}) == 6);
        System.out.println(solution.maxProfit(new int[]{1, 2, 3, 1, 2}) == 2);
        System.out.println(solution.maxProfit(new int[]{1, 2}) == 1);
        System.out.println(solution.maxProfit(new int[]{3, 2}) == 0);
        System.out.println(solution.maxProfit(new int[]{1, 4, 2}) == 3);
        System.out.println(solution.maxProfit(new int[]{6, 1, 6, 4, 3, 0, 2}) == 7);
    }
}
