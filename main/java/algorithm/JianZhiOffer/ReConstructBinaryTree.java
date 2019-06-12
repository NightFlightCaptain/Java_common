package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/17 20:32
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		return reConstructBinaryTree(0, pre.length - 1, 0, in.length - 1, pre, in);
	}

	private TreeNode reConstructBinaryTree(int preStart, int preEnd, int inStart, int inEnd, int[] pre, int[] in) {
		int length = pre.length;
		if (preStart > preEnd || inStart > inEnd || length == 0) {
			return null;
		}
		TreeNode treeNode = new TreeNode(pre[preStart]);
		for (int i = inStart; i <= inEnd; i++) {
			if (pre[preStart] == in[i]) {
				treeNode.left = reConstructBinaryTree(preStart + 1, preStart + i - inStart, inStart, i - 1, pre, in);
				treeNode.right = reConstructBinaryTree(preStart+1+i - inStart, preEnd, i + 1, inEnd, pre, in);
				break;
			}
		}
		return treeNode;
	}

	public static void main(String[] args) {
		ReConstructBinaryTree solution = new ReConstructBinaryTree();
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
		TreeNode treeNode = solution.reConstructBinaryTree(pre, in);
		System.out.println(treeNode);
	}
}
