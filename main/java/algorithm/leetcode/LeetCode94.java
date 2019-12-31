package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 【二叉树的中序遍历】
 * <p>
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/31 9:53
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        boolean isBack = false;

        TreeNode point = root;
        while (true) {
            if (!isBack && point.left != null) {
                TreeNode temp = point;
                stack.push(temp);
                point = point.left;
            } else {
                result.add(point.val);
                if (point.right != null) {
                    point = point.right;
                    isBack = false;
                } else if (!stack.isEmpty()) {
                    point = stack.pop();
                    isBack = true;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode94 solution = new LeetCode94();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(solution.inorderTraversal(treeNode));
        treeNode = TreeNode.getTreeNode(new int[]{1, 2, 3, 0, 0, 0, 4});
        System.out.println(solution.inorderTraversal(treeNode));
        treeNode = TreeNode.getTreeNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(solution.inorderTraversal(treeNode));

        treeNode = TreeNode.getTreeNode(new int[]{1, 2, 3, 4, 5, 0, 0,6,0,0,7});
        System.out.println(solution.inorderTraversal(treeNode));

        treeNode = TreeNode.getTreeNode(new int[]{1});
        System.out.println(solution.inorderTraversal(treeNode));

    }
}
