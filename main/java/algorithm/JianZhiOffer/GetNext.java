package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/24 9:31
 * <p>
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {

	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		return getNode(pNode);
	}

	private TreeLinkNode getNode(TreeLinkNode node) {
		if (node.right != null) {
			node = node.right;
			while (node.left != null) {
				node = node.left;
			}
			return node;
		} else {

			while (node.next != null&&node.next.right == node){
				node = node.next;
			}
			return node.next;
		}
	}

	public static void main(String[] args) {

	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode next = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}
