package algorithm.datastruct.tree;

import algorithm.JianZhiOffer.TreeNode;

import java.util.LinkedList;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 22:46
 *
 * 打印树每层的第一个节点
 */
public class PrintFirstSequence {
	private void printFirstSequence(TreeNode root){
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left!=null){
				queue.add(node.left);
				continue;
			}
			if (node.right!=null){
				queue.add(node.right);
			}
		}
	}
	public static void main(String[] args) {
		PrintFirstSequence printFirstSequence = new PrintFirstSequence();
		int[] a = {1,2,3,0,4,5,6,7};
		TreeNode treeNode = TreeNode.getTreeNode(a);
		printFirstSequence.printFirstSequence(treeNode);
	}
}
