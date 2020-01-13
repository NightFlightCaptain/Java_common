package algorithm.leetcode.competition.weekdouble17;

import algorithm.JianZhiOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【1315 祖父节点值为偶数的节点和】
 * <p>
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 * <p>
 * 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在 1 到 10^4 之间。
 * 每个节点的值在 1 到 100 之间。
 *
 * @author: 小栗旬
 * @Date: 2020/1/11 23:47
 */
public class LeetCode5145 {
    public int sumEvenGrandparent(TreeNode root) {
        return dfsMethod(root);
    }

    int sum;
    /* dfs版本 */

    private int dfsMethod(TreeNode root) {
        sum =0;
        dfsHelper(root,-1,-1);
        return sum;
    }

    private void dfsHelper(TreeNode root, int fa, int gfa) {
        if (root == null) {
            return;
        }
        if (gfa != -1 && ((gfa & 1) == 0)) {
            sum += root.val;
        }
        dfsHelper(root.left,root.val,fa);
        dfsHelper(root.right,root.val,fa);
    }


    /*  自己写的版本 */

    private int cycleMethod(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        if (root.left != null) {
            queue.add(root.left);
        }
        if (root.right != null) {
            queue.add(root.right);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left != null) {
                    if ((node.val & 1) == 0) {
                        res += node.left.left.val;
                    }
                    queue.add(node.left.left);
                }
                if (node.left.right != null) {
                    if ((node.val & 1) == 0) {
                        res += node.left.right.val;
                    }
                    queue.add(node.left.right);
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    if ((node.val & 1) == 0) {
                        res += node.right.left.val;
                    }
                    queue.add(node.right.left);
                }
                if (node.right.right != null) {
                    if ((node.val & 1) == 0) {
                        res += node.right.right.val;
                    }
                    queue.add(node.right.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode5145 solution = new LeetCode5145();
        System.out.println(solution.sumEvenGrandparent(TreeNode.getTreeNode(new int[]{6, 7, 8, 2, 7, 1, 3, 9, 0, 1, 4, 0, 0, 0, 5}))==18);
        System.out.println(solution.sumEvenGrandparent(TreeNode.getTreeNode(new int[]{50, 0, 54, 98, 6, 0, 0, 0, 34})));
        System.out.println(solution.sumEvenGrandparent(TreeNode.getTreeNode(new int[]{79, 52, 86, 71, 12, 0, 2, 0, 0, 0, 81, 91, 1, 0, 0, 0, 0, 0, 93})));
    }
}
