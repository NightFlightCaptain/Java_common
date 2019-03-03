package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/3 21:23
 * <p>
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced_Solution {
	public boolean IsBalanced_Solution(TreeNode root) {
		return findDepth(root) != -1;
	}

	private int findDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftLength = findDepth(node.left);
		if (leftLength == -1) {
			return -1;
		}
		int rightLength = findDepth(node.right);
		if (rightLength == -1) {
			return -1;
		}
		if (Math.abs(leftLength - rightLength) >= 2) {
			return -1;
		}
		return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
	}

	public static void main(String[] args) {

		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);

		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		treeNode2.right = treeNode4;
		treeNode3.left = treeNode5;
		treeNode3.right = treeNode6;

		IsBalanced_Solution solution = new IsBalanced_Solution();
		System.out.println(solution.IsBalanced_Solution(treeNode1));
	}
}

