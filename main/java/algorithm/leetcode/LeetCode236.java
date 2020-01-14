package algorithm.leetcode;

import algorithm.JianZhiOffer.TreeNode;

/**
 * 【二叉树的最近公共祖先】
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/14 15:33
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor2(root, p, q);
    }

    private TreeNode normalMethod(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        // left和right分别表示在左边和右边有没有找到p或者q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // p,q分别在root的左右
        if (left != null && right != null) {
            return root;
        }
        // 左边有
        if (left != null) {
            return left;
        }
        // 右边有
        if (right != null) {
            return right;
        }
        // 两边都没有
        return null;
    }

    /* 上述方法假设一定能找到，如果找不到公共节点如何做呢 */

    TreeNode res = null;

    private TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        isExist(root, p, q);
        return res;
    }

    private boolean isExist(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int leftExist = isExist(root.left, p, q) ? 1 : 0;
        int rightExist = isExist(root.right, p, q) ? 1 : 0;
        int curExist = (root == q || root == p) ? 1 : 0;
        if (leftExist + rightExist + curExist == 2) {
            res = root;
        }
        if (leftExist + rightExist + curExist > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LeetCode236 solution = new LeetCode236();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node3.left = node6;
        node3.right = node7;
        TreeNode nodeNone = new TreeNode(11);
        System.out.println(solution.lowestCommonAncestor(node1, node3, node7));


    }
}
