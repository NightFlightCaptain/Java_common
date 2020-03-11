package algorithm.tree;

import algorithm.JianZhiOffer.TreeNode;

import java.util.Stack;

/**
 * @author: 小栗旬
 * @Date: 2019/11/3 13:24
 */
public class Print {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode(new int[]{1, 2, 3, 4, 5, 0, 6, 0, 0, 7, 8});
        afterPrint2(treeNode);
//        beforePrint(treeNode);
//        treeNode = TreeNode.getTreeNode(new int[]{3,9,20,15,17,0,7});
//        midPrint(treeNode);
    }

    private static void afterPrint2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;
        while (node != null || !stack.isEmpty()) {
            if (node!=null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.peek();
                if (node.right!=null && node.right!=last){
                    node = node.right;
                }else {
                    last = node;
                    System.out.println(node.val);
                    stack.pop();
                    node = null;
                }
            }
        }
    }

    /**
     * 后续遍历
     * 重点是回退的时候是从左边回退上去还是从右边回退上去
     * 如果是从左边，那么接下来应该访问节点的右边节点
     * 如果是从右边，那么接下来应该访问父节点
     *
     * @param root
     */
    private static void afterPrint(TreeNode root) {
        int left = 1;
        int right = 2;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> direction = new Stack<>();
        direction.push(1);
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                direction.push(1);
                root = root.left;
            }

            while (!stack.isEmpty() && direction.peek() == right) {
                direction.pop();
                System.out.println(stack.pop().val);
            }

            if (!stack.isEmpty() && direction.peek() == left) {
                direction.pop();
                direction.push(right);
                root = stack.peek().right;
            }
        }

    }

    /**
     * 前序遍历。先输出节点，然后把右边入栈，再把左边入栈
     *
     * @param node
     */
    private static void beforePrint(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (node != null) {
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 中序遍历，判断左子树是否空，不空则入栈。
     * 如果为空，则立马输出当前，然后指向右子树，把右子树当成一个完整的树
     *
     * @param node
     */
    private static void midPrint(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
        }
    }


}
