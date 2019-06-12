package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/6/12 20:34
 * <p>
 *
 *      代码的鲁棒性-链表中倒数第k个结点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {
	public ListNode findKthToTail(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode kThNode = head;
		while (k > 0) {
			if (kThNode == null) {
				return null;
			}
			kThNode = kThNode.next;
			k--;
		}
		ListNode result = head;
		while (kThNode != null) {
			result = result.next;
			kThNode = kThNode.next;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] array = {1, 4, 3, 5, 12, 9, 7};
		ListNode node = ListNode.getListNode(array);
		FindKthToTail solution = new FindKthToTail();
		System.out.println(solution.findKthToTail(node, 7).val);
	}
}
