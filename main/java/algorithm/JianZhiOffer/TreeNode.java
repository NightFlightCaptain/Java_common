package algorithm.JianZhiOffer;

import java.util.LinkedList;

public class TreeNode {
	public int val = 0;
	public TreeNode left = null;
	public TreeNode right = null;

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
