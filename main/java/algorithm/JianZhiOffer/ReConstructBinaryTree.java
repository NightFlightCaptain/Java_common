package algorithm.JianZhiOffer;

import java.util.LinkedList;

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

	}

	private TreeNode get(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = preStart; i < preEnd; i++) {
			for (int j = inStart; j < preEnd; j++) {
				if (pre[i] == in[j]) {
					TreeNode treeNode = new TreeNode(pre[i]);
					treeNode.left = get(pre, i+1, j, in, inStart, inEnd);
					treeNode.right = get(pre, j + 1, preEnd, in, j+1, inEnd);
				}
			}
		}
	}

	public static void main(String[] args) {
//		ReConstructBinaryTree solution = new ReConstructBinaryTree();
//		int[] pre = {1,2,4,7,3,5,6,8};
//		int[] in ={4,7,2,1,5,3,8,6};
//		System.out.println(solution.reConstructBinaryTree(pre, in));
	}
}
