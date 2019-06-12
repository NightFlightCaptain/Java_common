package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/23 10:50
 * <p>
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) {
			return null;
		}
		ListNode head = new ListNode(-1);
		head.next = pHead;
		ListNode beforeNode = head;
		ListNode node = pHead;

		/* 1,1,3,3
		 * 重点是如何处理1，3之间的关系，虽然他们之间不同，但是11，33都重复了，他们都需要被删除。
		 * 通过判断当前节点是否和下一节点相同，如果相同,则进入相同的分支，指针不断后移，直到遇到第一个不同，
		 * 而且就算遇到了不同，也要舍弃当前节点，指针要指向下一个节点。这个时候可以看作是按照当前节点新开始，也就是保证了当前节点与上一节点不同
		 *
		 * */
		while (node != null) {
			if (node.next != null && node.val == node.next.val) {
				node = node.next;
				while (node.next != null && node.val == node.next.val) {
					node = node.next;
				}
				node = node.next;
				beforeNode.next = node;
			} else {
				beforeNode = node;
				node = node.next;
			}
		}
		return head.next;
	}

	public static void main(String[] args) {
		int[] ints = {1, 1, 3, 3, 4, 4, 5, 6, 7, 7, 7, 7, 8, 8, 9, 9, 10};
		ListNode head = ListNode.getListNode(ints);
		System.out.println(head.toString());
		DeleteDuplication solution = new DeleteDuplication();
		System.out.println(solution.deleteDuplication(head).toString());
	}
}
