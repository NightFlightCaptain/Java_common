package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 18:40
 * <p>
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		return isSame(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
	}

	private boolean isSame(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}
		if (root1 ==null){
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		}
		return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
	}

	public static void main(String[] args) {
		int[] a = {8, 8, 7, 9, 2, 0, 0, 0, 0, 4, 7};
		int[] b = {8, 9, 2};
		HasSubtree solution = new HasSubtree();
		System.out.println(solution.hasSubtree(TreeNode.getTreeNode(a), TreeNode.getTreeNode(b)));
	}
}
