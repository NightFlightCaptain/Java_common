package algorithm.JianZhiOffer;


/**
 * Author: 小栗旬
 * Date: 2019/3/3 21:08
 * <p>
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
	public int TreeDepth(TreeNode root) {
		if (root==null){
			return 0;
		}
		return findDepth(root);
	}

	private int findDepth(TreeNode node) {
		int leftLength = 0;
		int rightLength = 0;
		if (node.left != null) {
			leftLength = findDepth(node.left);
		}
		if (node.right != null) {
			rightLength = findDepth(node.right);
		}
		return leftLength>rightLength?leftLength+1:rightLength+1;
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
		treeNode4.left = treeNode5;
		treeNode4.right = treeNode6;

		TreeDepth solution = new TreeDepth();
		System.out.println(solution.findDepth(treeNode1));


	}
}

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;

	}
}