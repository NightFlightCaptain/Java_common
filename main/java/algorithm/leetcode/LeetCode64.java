package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【最小路径和】
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/8 13:49
 */
public class LeetCode64 {
    public int minPathSum(int[][] grid) {
        return dpMethod(grid);
    }

    private int dpMethod(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[j] = grid[i][j - 1] + Math.min(dp[j - 1],dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LeetCode64 solution = new LeetCode64();
        int[][] paths = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(paths));
        paths = new int[][]{
                {1, 3, 1},
                {101, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(paths));
        paths = new int[][]{
                {1, 3, 1, 7},
                {1, 5, 1, 3},
                {4, 2, 1, 9}
        };
        System.out.println(solution.minPathSum(paths));
        paths = new int[][]{
                {1, 2},
                {1, 1}
        };
        System.out.println(solution.minPathSum(paths));
        paths = new int[][]{

        };
        System.out.println(solution.minPathSum(paths));
    }
}
