package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

import java.util.LinkedList;

/**
 * 【二叉树的最大深度】
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/2 16:35
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    private int iterateMethod(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        int depth = 0;

        while (!treeNodeList.isEmpty()) {
            int size = treeNodeList.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeList.pollFirst();
                if (node.left != null) {
                    treeNodeList.add(node.left);
                }
                if (node.right != null) {
                    treeNodeList.add(node.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        LeetCode104 solution = new LeetCode104();
        TreeNode treeNode = TreeNode.getTreeNode(new int[]{3, 9, 10, 0, 0, 15, 7});
        System.out.println(solution.maxDepth(treeNode));
        treeNode = TreeNode.getTreeNode(new int[]{});
        System.out.println(solution.maxDepth(treeNode));
        treeNode = TreeNode.getTreeNode(new int[]{1, 2});
        System.out.println(solution.maxDepth(treeNode));
    }
}
