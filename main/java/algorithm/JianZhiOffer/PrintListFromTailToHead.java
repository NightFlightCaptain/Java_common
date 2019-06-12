package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/4/17 20:14
 * <p>
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {
	ArrayList<Integer> arrayList = new ArrayList<>();

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		/* 使用LinkedList或者Stack的垃圾解法
		LinkedList<Integer> list = new LinkedList<>();
		while (listNode != null) {
			list.push(listNode.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> arrayList = new ArrayList<>(list);
		return arrayList;
		*/
		if (listNode == null){
			return arrayList;
		}
		if (listNode.next != null) {
			printListFromTailToHead(listNode.next);
		}
		arrayList.add(listNode.val);

		return arrayList;
	}

	public static void main(String[] args) {
		int[] a = {};
		PrintListFromTailToHead solution = new PrintListFromTailToHead();
		System.out.println(ListNode.getListNode(a));
		System.out.println(solution.printListFromTailToHead(ListNode.getListNode(a)));
	}
}
