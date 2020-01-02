package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 【二叉树的层次遍历】
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/2 16:15
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null){
            return result;
        }

        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);

        while (!treeNodeList.isEmpty()) {
            int size = treeNodeList.size();
            List<Integer> currentLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeList.pollFirst();

                currentLevel.add(node.val);
                if (node.left != null) {
                    treeNodeList.add(node.left);
                }
                if (node.right != null) {
                    treeNodeList.add(node.right);
                }

            }
            result.add(currentLevel);
        }
        return result;
    }

    public static void main(String[] args) {

        LeetCode102 solution = new LeetCode102();
        TreeNode head = TreeNode.getTreeNode(new int[]{3, 9, 20, 0, 0, 15, 7});
        System.out.println(solution.levelOrder(head));
        head = TreeNode.getTreeNode(new int[]{});
        System.out.println(solution.levelOrder(head));

    }
}
