package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/3/26 20:40
 * <p>
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTree {

	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		if (pRoot==null){
			return new ArrayList<>();
		}
		ArrayList<TreeNode> treeNodes = new ArrayList<>();

		treeNodes.add(pRoot);
		return get(treeNodes);
	}

	private ArrayList<ArrayList<Integer>> get(ArrayList<TreeNode> treeNodes) {
		ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

		boolean left = true;
		while (treeNodes.size() != 0) {
			ArrayList<Integer> integers = new ArrayList<>();
			ArrayList<TreeNode> newTreeNodes = new ArrayList<>();
			int length = treeNodes.size();
			for (int i = 0; i < length; i++) {
				if (left) {
					integers.add(treeNodes.get(i).val);
				} else {
					integers.add(treeNodes.get(length - 1 - i).val);
				}
				if (treeNodes.get(i).left != null) {
					newTreeNodes.add(treeNodes.get(i).left);
				}
				if (treeNodes.get(i).right != null) {
					newTreeNodes.add(treeNodes.get(i).right);
				}
			}
			arrayLists.add(integers);
			treeNodes = newTreeNodes;
			left = !left;
		}
		return arrayLists;
	}

	public static void main(String[] args) {

	}
}
