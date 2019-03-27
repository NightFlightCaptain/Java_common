package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/3/27 20:11
 * <p>
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Print2 {

	ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

		if (pRoot==null) return arrayLists;
		ArrayList<TreeNode> treeNodes = new ArrayList<>();

		treeNodes.add(pRoot);
		getArrayList(treeNodes);
		return arrayLists;
	}

	private void getArrayList(ArrayList<TreeNode> treeNodes) {
		while (treeNodes.size() != 0) {
			ArrayList<TreeNode> newTreeNodes = new ArrayList<>();
			ArrayList<Integer> integers = new ArrayList<>();
			for (TreeNode treeNode:treeNodes) {
				integers.add(treeNode.val);
				if (treeNode.left != null) {
					newTreeNodes.add(treeNode.left);
				}
				if (treeNode.right != null) {
					newTreeNodes.add(treeNode.right);
				}
			}
			arrayLists.add(integers);
			treeNodes = newTreeNodes;
		}

	}

	public static void main(String[] args) {
		int[] ints = {1,2,3,0,0,4,5,6,7};
		TreeNode root = TreeNode.getTreeNode(ints);
		Print2 solution = new Print2();
		System.out.println(solution.Print(root));
	}
}
