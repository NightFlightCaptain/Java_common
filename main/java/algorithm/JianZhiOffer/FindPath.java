package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/7/27 7:33
 * <p>
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	ArrayList<Integer> integers = new ArrayList<>();

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		if (root == null || target<0) {
			return result;
		}
		integers.add(root.val);
		target -= root.val;
		if (0 == target && root.left == null && root.right == null) {
			result.add(new ArrayList<>(integers));
		}
		findPath(root.left, target);
		findPath(root.right, target);
		integers.remove(integers.size()-1);
		return result;
	}


	public static void main(String[] args) {
		FindPath solution = new FindPath();
		int[] nodeVals = {1, 2, 3, 6, 4, 5, 7, 0,0,0,2};
		TreeNode root = TreeNode.getTreeNode(nodeVals);
		System.out.println(solution.findPath(root, 9));
	}
	/*
	*     1
	*   2   3
	* 6 4  5  7
	*    2
	* */
}
