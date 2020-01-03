package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

/**
 * 【二叉树中的最大路径和】
 * <p>
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/3 14:45
 */
public class LeetCode124 {
    private int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        simpleMethod(root);
        return maxPath;
    }

    private int simpleMethod(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = Math.max(simpleMethod(root.left), 0);
        int rightValue = Math.max(simpleMethod(root.right), 0);
        /* 在计算最大值的时候，当前节点一定要纳入计算，
        不用考虑“只要左边最大或者只要右边最大”的情况，这种情况在其他节点作为根节点的时候考虑计算 */
        int value = root.val + leftValue + rightValue;
        maxPath = Math.max(value, maxPath);

        return root.val + Math.max(leftValue, rightValue);
    }

    /**
     * @param root
     * @return 以当前节点为根节点的单边最大值
     */
    private int findSingleSideMaxValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftValue = findSingleSideMaxValue(root.left);
        int rightValue = findSingleSideMaxValue(root.right);

        // 如果左边和右边同时<=0，那么只考虑当前节点即可
        if (leftValue <= 0 && rightValue <= 0) {
            maxPath = Math.max(maxPath, root.val);
            return root.val;
        }
        // 只用来和maxPath比较的数
        int value;

        int bigValue = Math.max(leftValue, rightValue);
        int smallValue = Math.min(leftValue, rightValue);

        value = bigValue;
        // 只加上根节点
        if (root.val > 0 && smallValue < 0) {
            value += root.val;
            // 如果根节点和较小边的节点和>0 那么就把他们加上
        } else if (root.val + smallValue > 0) {
            value += root.val + smallValue;
        }

        maxPath = Math.max(maxPath, value);
        return bigValue + root.val;
    }

    public static void main(String[] args) {
        LeetCode124 solution = new LeetCode124();
        int[][] testArrays = new int[][]{
                {1, 2, 3},
                {-10, 9, 20, 0, 0, 15, 7},
                {-1},
                {-1, 0, 2},
                {-1, -2, -3},
                {-1, -2, -3, 2},
                {1, -2, 3}
        };
        int[] resultArray = new int[]{6, 42, -1, 2, -1, 2, 4};
        for (int i = 0; i < resultArray.length; i++) {
            TreeNode node = TreeNode.getTreeNode(testArrays[i]);
            System.out.println(solution.maxPathSum(node) == resultArray[i]);
        }

    }
}
