package algorithm.leetcode;

/**
 * 【不同的二叉搜索树】
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/31 10:34
 */
public class LeetCode96 {
    public int numTrees(int n) {

        return cycleMethod(n);
    }

    private int cycleMethod(int n) {
        if (n == 0 || n==1||n==2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    private int recursiveMethod(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                count += numTrees(n - 1);
            } else {
                count += numTrees(i) * numTrees(n - i - 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LeetCode96 solution = new LeetCode96();
        System.out.println(solution.numTrees(0));
        System.out.println(solution.numTrees(1));
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(4));
    }
}
