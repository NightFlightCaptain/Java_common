package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 19:13
 * <p>
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class Mirror {
	public void mirror(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

	public static void main(String[] args) {
		int[] a = {8, 6, 10, 5, 7, 9, 11};
		Mirror solution = new Mirror();
		TreeNode node = TreeNode.getTreeNode(a);
		System.out.println(node);
		solution.mirror(node);
		System.out.println(node);

	}
}
