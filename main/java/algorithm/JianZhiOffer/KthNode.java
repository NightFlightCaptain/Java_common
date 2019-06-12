package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/30 9:18
 * <p>
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
	//	LinkedList<TreeNode> list = new LinkedList<>();
	int count = 0;

	TreeNode KthNode(TreeNode pRoot, int k) {
		return get(pRoot, k);
	}

	private TreeNode get(TreeNode node, int k) {
		if (node == null) {
			return null;
		}
		TreeNode node1 = get(node.left, k);
		if (node1 != null) {
			return node1;
		}
		if (++count == k) {
			return node;
		}
		node1 = get(node.right, k);
		if (node1 != null) {
			return node1;
		}
		return null;
	}

	public static void main(String[] args) {
		KthNode solution = new KthNode();
		int[] vals = {8, 6, 10, 5, 7, 9, 11};
		TreeNode node = TreeNode.getTreeNode(vals);
//		System.out.println(solution.KthNode(null, 1));
//		System.out.println(node.toString());
		System.out.println(solution.KthNode(node, 3).val);
	}
}
