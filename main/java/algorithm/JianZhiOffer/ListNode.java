package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/22 21:48
 *
 * val 表示当前节点的值
 * next 下一节点
 *
 */

public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}

	public static ListNode getListNode(int[] ints){
		ListNode head = new ListNode(-1);
		ListNode first = head;
		for (int i = 0; i < ints.length; i++) {
			ListNode node = new ListNode(ints[i]);
			first.next = node;
			first = node;
		}
		return head.next;
	}

	@Override
	public String toString() {
		if (next == null){
			return String.valueOf(val);
		}
		return val+"->"+next.toString();
	}
}
