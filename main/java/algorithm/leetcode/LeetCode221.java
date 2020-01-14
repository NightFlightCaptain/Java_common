package algorithm.leetcode;

/**
 * 【最大正方形】
 * <p>
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/14 12:49
 */
public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return 0;
        }
        int col = matrix[0].length;
        int[] dp = new int[col + 1];
        int last = 0;
        int max = 0;
        for (int i = 0; i < row ; i++) {
            for (int j = 1; j < col + 1; j++) {
                int tem = dp[j];
                if (matrix[i][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], dp[j]), last) + 1;
                    max = Math.max(max, dp[j]);
                } else {
                    dp[j] = 0;
                }
                last = tem;
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        LeetCode221 solution = new LeetCode221();
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        }) == 4);
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'}
        }) == 1);
        System.out.println(solution.maximalSquare(new char[][]{
                {'0', '0', '0', '0', '0'}
        }) == 0);
        System.out.println(solution.maximalSquare(new char[][]{
                {'0'}
        }) == 0);
        System.out.println(solution.maximalSquare(new char[][]{
                {}
        }) == 0);
        System.out.println(solution.maximalSquare(new char[][]{
                {'0'},
                {'1'},
                {'1'},
                {'1'},
                {'0'}
        }) == 1);
        System.out.println(solution.maximalSquare(new char[][]{
                {'1', '1'},
                {'1', '1'}
        }) == 4);
    }
}
