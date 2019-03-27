package algorithm.JianZhiOffer;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Author: 小栗旬
 * Date: 2019/3/27 21:09
 */
public class Serialize {
	public static void main(String[] args) {
//		String a = "";
//		Serialize solution = new Serialize();
//		System.out.println(solution.Deserialize(a).toString());
		String[] strings = "".split(",");
		Arrays.toString(strings);
		System.out.println(strings.length);
	}
	String Serialize(TreeNode root) {
		if (root==null){
			return "";
		}
		LinkedList<TreeNode> stack = new LinkedList<>();
		StringBuilder stringBuilder = new StringBuilder();
		stack.offer(root);
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
	TreeNode Deserialize(String str) {
		if (str.equals("")){
			return null;
		}
		String[] strings = str.split(",");
		int[] vals = new int[strings.length];
		for (int i =0;i<vals.length;i++){
			vals[i] = Integer.valueOf(strings[i]);
		}
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


}
