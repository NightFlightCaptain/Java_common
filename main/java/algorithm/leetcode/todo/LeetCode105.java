package algorithm.leetcode.todo;

import algorithm.JianZhiOffer.TreeNode;

import java.util.HashMap;

/**
 * 【从前序与中序遍历序列构造二叉树】
 * <p>
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/2 18:14
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return secondMethod(preorder, inorder);
    }

    private TreeNode firstMethod(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd,
                               int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int value = preorder[preStart];

        int count = 0;
        while (inorder[inStart + count] != value) {
            count++;
        }

        TreeNode node = new TreeNode(value);
        node.left = buildTree(preorder, inorder, preStart + 1, preStart + count, inStart, inStart + count - 1);
        node.right = buildTree(preorder, inorder, preStart + count + 1, preEnd, inStart + count + 1, inEnd);
        return node;
    }

    /*第二种方法*/

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] preorder;
    private int[] inorder;
    private int preIndex = 0;

    private TreeNode secondMethod(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        if (preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return secondHelper(0, inorder.length - 1);
    }

    private TreeNode secondHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        int value = preorder[preIndex];
        TreeNode node = new TreeNode(value);

        int index = map.get(value);
        preIndex++;
        node.left = secondHelper(start, index - 1);
        node.right = secondHelper(index + 1, end);
        return node;
    }


    public static void main(String[] args) {
        LeetCode105 solution = new LeetCode105();
//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};
//        System.out.println(solution.buildTree(preorder, inorder));
//
//        preorder = new int[]{1, 2};
//        inorder = new int[]{2, 1};
//        System.out.println(solution.buildTree(preorder, inorder));
//
//        preorder = new int[]{1, 2};
//        inorder = new int[]{1, 2};
//        System.out.println(solution.buildTree(preorder, inorder));

        int[] preorder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(solution.buildTree(preorder, inorder));

    }

}
