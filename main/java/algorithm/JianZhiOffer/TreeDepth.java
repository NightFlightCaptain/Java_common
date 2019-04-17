package algorithm.JianZhiOffer;


import java.util.*;

/**
 * Author: 小栗旬
 * Date: 2019/3/3 21:08
 * <p>
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
	public int TreeDepth(TreeNode root) {
		if (root == null) {
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
		return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
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

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 0,0,0, 4, 5, 6, 7};
		TreeNode node = TreeNode.getTreeNode(numbers);
		System.out.println(node);
	}

	public static TreeNode getTreeNode(int[] vals) {
		if (vals.length <= 0) {
			return null;
		}
		TreeNode node = new TreeNode(vals[0]);
		LinkedList<TreeNode> linkedList = new LinkedList<>();
		linkedList.offer(node);
		boolean left = true;
		for (int i = 1; i < vals.length; i++) {
			TreeNode newNode;
			if (vals[i] == 0) {
				newNode = null;
			} else {
				newNode = new TreeNode(vals[i]);
			}
			if (left) {
				TreeNode node1 = linkedList.peek();
				node1.left = newNode;

			} else {
				TreeNode node1 = linkedList.poll();
				node1.right = newNode;
			}
			left = !left;
			if (newNode != null) {
				linkedList.offer(newNode);
			}
		}
		return node;
	}


	@Override
	public String toString() {
		LinkedList<TreeNode> stack = new LinkedList<>();
		StringBuilder stringBuilder = new StringBuilder();
		stack.offer(this);
		int count = 1;
		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.poll();
			if (treeNode == null) {
				if (!stack.isEmpty() && count != 0) {
					stringBuilder.append("0").append(",");
				}
				continue;
			}
			stringBuilder.append(treeNode.val).append(",");
			count--;
			stack.offer(treeNode.left);
			if (treeNode.left != null) {
				count++;
			}
			stack.offer(treeNode.right);
			if (treeNode.right != null) {
				count++;
			}
		}
		return stringBuilder.substring(0, stringBuilder.length() - 1);
	}
}