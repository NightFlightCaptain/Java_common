package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

import java.util.Stack;

/**
 * 【翻转二叉树】
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * <p>
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/14 13:28
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            TreeNode tem = cur.left;
            cur.left = cur.right;
            cur.right = tem;
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right!=null){
                stack.push(cur.right);
            }
        }
        return root;
    }

    /* 递归方法 */

    private TreeNode recursiveMethod(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tem = root.left;
        root.left = recursiveMethod(root.right);
        root.right = recursiveMethod(tem);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(new int[]{4, 2, 7, 1, 3, 6, 9});
        LeetCode226 solution = new LeetCode226();
        System.out.println(solution.invertTree(treeNode));
    }
}
