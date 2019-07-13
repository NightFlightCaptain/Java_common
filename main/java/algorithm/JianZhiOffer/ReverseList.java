package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 15:15
 * <p>
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {


		ListNode pre = null;
		ListNode next = null;
		while (head != null) {/*循环中做的就是标记下一节点，然后将当前节点指向上一节点*/
			next = head.next;
			head.next = pre;

			pre = head;
			head = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		int[] a = {};
		ListNode head = ListNode.getListNode(a);
		ReverseList solution = new ReverseList();
		System.out.println(solution.reverseList(head));
	}
}
