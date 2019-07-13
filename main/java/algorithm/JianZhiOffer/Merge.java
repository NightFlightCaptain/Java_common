package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/7/13 18:27
 * <p>
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {
	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode node = null;
		if (list1==null && list2==null){
			return node;
		}
		if (list1==null ||(list2!=null && list1.val > list2.val)) {
			node = new ListNode(list2.val);
			node.next = merge(list1,list2.next);
		} else {
			node = new ListNode(list1.val);
			node.next = merge(list1.next,list2);
		}

		return node;
	}

	public static void main(String[] args) {
		Merge solution = new Merge();
		int[] a = {};
		int[] b = {};
		ListNode node = solution.merge(ListNode.getListNode(a),ListNode.getListNode(b));
		System.out.println(node);
	}
}
