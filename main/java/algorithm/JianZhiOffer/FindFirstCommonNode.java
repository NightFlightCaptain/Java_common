package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/1 15:14
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

		/*
		链接：https://www.nowcoder.com/questionTerminal/6ab1d9a29e88450685099d45c9e31e46
		来源：牛客网

		简约版c++代码，第一次遍历可以得到两个链表的差值，第二次遍历就可以弥补这个插值

		class Solution {
		public:
		    ListNode* FindFirstCommonNode( ListNode *pHead1, ListNode *pHead2) {
		        ListNode *p1 = pHead1;
		        ListNode *p2 = pHead2;
		        while(p1!=p2){
		            p1 = (p1==NULL ? pHead2 : p1->next);
		            p2 = (p2==NULL ? pHead1 : p2->next);
		        }
		        return p1;
		    }
		};
		 */
		if (pHead1 == null || pHead2 == null) {
			return null;
		}

		int count_dif = getLength(pHead1) - getLength(pHead2);
		if (count_dif > 0) {
			pHead1=walkLength(pHead1, count_dif);
		} else {
			pHead2=walkLength(pHead2, -count_dif);
		}
		while (pHead1 != null && pHead2 != null && pHead1.val != pHead2.val) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		return pHead1;
	}

	private int getLength(ListNode tmp) {
		int count = 0;
		while (tmp.next != null) {
			count++;
			tmp = tmp.next;
		}
		return count;
	}

	private ListNode walkLength(ListNode listNode, int length) {
		while (length > 0) {
			listNode = listNode.next;
			length--;
		}
		return listNode;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);

		node1.next = node2;
		node2.next = node3;
		node3.next = node6;
		node6.next = node7;

		node4.next = node5;
		node5.next = node6;

		FindFirstCommonNode solution = new FindFirstCommonNode();
		System.out.println(solution.FindFirstCommonNode(node1, node4).val);
	}
}


