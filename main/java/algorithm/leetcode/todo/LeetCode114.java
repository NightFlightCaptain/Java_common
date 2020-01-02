package algorithm.leetcode.todo;

import algorithm.JianZhiOffer.TreeNode;

/**
 * 【二叉树展开为链表】
 * <p>
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/2 20:14
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        simpleMethod(root);
    }


//    private TreeNode helper(TreeNode root) {
//
//    }

    private void simpleMethod(TreeNode root){
        while (root!=null){
            if (root.left==null){
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right!=null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
    public static void main(String[] args) {
        LeetCode114 solution = new LeetCode114();
        TreeNode treeNode = TreeNode.getTreeNode(new int[]{1, 2, 5, 3, 4, 0, 6});
        solution.flatten(treeNode);
        System.out.println(treeNode);
    }
}
