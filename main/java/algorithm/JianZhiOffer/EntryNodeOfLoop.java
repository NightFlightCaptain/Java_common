package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/23 10:24
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode step2Node = pHead;
		ListNode step1Node = pHead;
		int loopLength = getLoopLength(step2Node,step1Node);
		if (loopLength == 0){
			return null;
		}
		return getBeginOfLoop(loopLength,pHead);

	}

	private int getLoopLength(ListNode step2Node, ListNode step1Node) {
		int count = 0;
		while (step2Node != null && step2Node.next != null) {

			step2Node = step2Node.next.next;
			step1Node = step1Node.next;
			count++;
			if (step1Node == step2Node){
				return count;
			}
		}
		return 0;
	}

	private ListNode getBeginOfLoop(int loopLength,ListNode head){
		ListNode node = head;
		while (loopLength--!=0){
			node = node.next;
		}
		while (node!=head){
			node=node.next;
			head=head.next;
		}
		return node;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode index = head;
		ListNode begin=null;
		for (int i =1;i<12;i++){
			ListNode node = new ListNode(i);
			index.next = node;
			if (i==7){
				begin = node;
			}
			index = node;
		}
		index.next = begin;
		EntryNodeOfLoop solution = new EntryNodeOfLoop();
		System.out.println(solution.EntryNodeOfLoop(head).val);
	}
}
