package algorithm.leetcode.todo;

import algorithm.JianZhiOffer.TreeNode;

/**
 * 【验证二叉搜索树】
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/2 14:17
 */
public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return isCor(root, null, null);
    }

    private boolean isCor(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) {
            return true;
        }
        int value = root.val;
        if (minValue != null && value <= minValue) {
            return false;
        }
        if (maxValue != null && value >= maxValue) {
            return false;
        }
        if (!isCor(root.left,minValue,value)){
            return false;
        }
        if (!isCor(root.right,value,maxValue)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode98 solution = new LeetCode98();

        TreeNode head = TreeNode.getTreeNode(new int[]{2, 1, 3});
        System.out.println(solution.isValidBST(head));
        head = TreeNode.getTreeNode(new int[]{5, 1, 4, 0, 0, 3, 6});
        System.out.println(solution.isValidBST(head));
        head = TreeNode.getTreeNode(new int[]{10, 5, 15, 0, 0, 6, 20});
        System.out.println(solution.isValidBST(head));
        head = TreeNode.getTreeNode(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE});
        System.out.println(solution.isValidBST(head));
    }
}
