package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 15:15
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {

		if (head==null||head.next == null) {
			return head;
		}
		//每次返回的节点都是末尾节点不变
		ListNode node = reverseList(head.next);
		//这两步保证当前节点的下一节点的下一节点指向自己，也就是反转
		head.next.next=head;
		head.next=null;

		return node;

		/*
		ListNode pre = null;
		ListNode next = null;
		while (head != null) {//循环中做的就是标记下一节点，然后将当前节点指向上一节点
			next = head.next;
			head.next = pre;

			pre = head;
			head = next;
		}
		return pre;
		*/
	}

	public static void main(String[] args) {
		int[] a = {};
		ListNode head = ListNode.getListNode(a);
		ReverseList solution = new ReverseList();
		System.out.println(solution.reverseList(head));
	}
}
