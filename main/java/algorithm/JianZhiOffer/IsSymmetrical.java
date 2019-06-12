package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/25 22:19
 * <p>
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {


	boolean isSymmetrical(TreeNode pRoot) {
		TreeNode node = getMirrorTree(pRoot);
		return isSame(node, pRoot);
	}


	/**
	 * 判断两棵树的值是否完全一样
	 *
	 * @param node1
	 * @param node2
	 * @return
	 */
	private boolean isSame(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		if (node1.val != node2.val) {
			return false;
		}
		return isSame(node1.right, node2.right) && isSame(node1.left, node2.left);
	}

	/**
	 * 获得镜像树
	 *
	 * @param root 被复制树的根节点
	 * @return 镜像树的根节点
	 */
	private TreeNode getMirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode newNode = new TreeNode(root.val);

		newNode.left = getMirrorTree(root.right);
		newNode.right = getMirrorTree(root.left);
		return newNode;
	}

	/**
	 *
	 * 解法二：
	 *
	 * 判断两棵树是否镜像
	 * @param treeNode1
	 * @param treeNode2
	 * @return
	 */
	private boolean isMirror(TreeNode treeNode1, TreeNode treeNode2) {
		if (treeNode1 == null && treeNode2 == null) {
			return true;
		}
		if (treeNode1 != null && treeNode2 != null) {
			return treeNode1.val == treeNode2.val
					&& isMirror(treeNode1.left, treeNode2.right)
					&& isMirror(treeNode1.right, treeNode2.left);
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
