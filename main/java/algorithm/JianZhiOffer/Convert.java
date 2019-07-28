package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/28 20:50
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {
	TreeNode head=null;
	TreeNode realHead=null;
	public TreeNode Convert(TreeNode pRootOfTree) {
		/*

		常规想法
		if (pRootOfTree == null) {
			return null;
		}
		if (pRootOfTree.left == null && pRootOfTree.right == null) {
			return pRootOfTree;
		}

		TreeNode leftNode = Convert(pRootOfTree.left);
		TreeNode p = leftNode;
		while (p != null && p.right != null) {//遍历到链表最右边的节点
			p = p.right;
		}
		if (pRootOfTree.left != null) {
			p.right = pRootOfTree;//将当前节点与最后边的节点联系
			pRootOfTree.left = p;
		}
		if (pRootOfTree.right != null) {
			TreeNode rightNode = Convert(pRootOfTree.right);//返回的本就是最左边的节点，所以不需要遍历
			rightNode.left = pRootOfTree;
			pRootOfTree.right = rightNode;
		}
		return leftNode != null ? leftNode : pRootOfTree;//保证每次返回的都是最左边的节点
		*/

		convertSub(pRootOfTree);
		return realHead;
	}

	private void convertSub(TreeNode root){
		if (root ==null){
			return;
		}
		convertSub(root.left);
		if (head == null){
			head = root;
			realHead = root;
		}else {
			head.right = root;
			root.left = head;
			head = root;
		}
		convertSub(root.right);
	}

	public static void main(String[] args) {
		Convert solution = new Convert();
		TreeNode root = TreeNode.getTreeNode(new int[]{10, 6, 14, 4, 8, 12, 16});
		root = solution.Convert(root);

		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
		System.out.println();
	}
}
