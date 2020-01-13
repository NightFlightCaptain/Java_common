package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

import java.util.LinkedList;

/**
 * 【对称二叉树】
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * 说明:
 * <p>
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/2 14:55
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        return iterateMethod(root);
    }

    /*  在考虑树的问题时，经常会使用到栈和队列两种数据结构  */
    private boolean iterateMethod(TreeNode root) {
        if (root == null){
            return true;
        }
        TreeNode tree1 = null;
        TreeNode tree2 = null;
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root.left);
        treeNodes.add(root.right);
        while (!treeNodes.isEmpty()){
            tree1 = treeNodes.pollFirst();
            tree2 = treeNodes.pollFirst();
            if (tree1 == null && tree2 == null){
                continue;
            }
            if (tree1 == null || tree2== null){
                return false;
            }
            if (tree1.val != tree2.val){
                return false;
            }
            treeNodes.add(tree1.left);
            treeNodes.add(tree2.right);
            treeNodes.add(tree1.right);
            treeNodes.add(tree2.left);
        }
        return true;
    }


    private boolean recursiveMethod(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        } else if (tree1 == null || tree2 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return isMirror(tree1.left, tree2.right) && isMirror(tree1.right, tree2.left);
    }

    public static void main(String[] args) {
        LeetCode101 solution = new LeetCode101();
        TreeNode treeNode = TreeNode.getTreeNode(new int[]{1, 2, 2, 3, 4, 4, 3});
        System.out.println(solution.isSymmetric(treeNode));
        treeNode = TreeNode.getTreeNode(new int[]{1, 2, 2, 0, 3, 0, 3});
        System.out.println(solution.isSymmetric(treeNode));
        treeNode = TreeNode.getTreeNode(new int[]{});
        System.out.println(solution.isSymmetric(treeNode));
    }


}
