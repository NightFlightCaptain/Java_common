package algorithm.datastruct.linked;

import algorithm.JianZhiOffer.ListNode;

/**
 * @author: 小栗旬
 * @Date: 2020/3/6 21:22
 */
public class ReverseDouble {

    /* 1，2，3，4，5，6，7  -> 1,6,3,4,5,2,7  奇数不变，偶数反转*/

    private static void fold(ListNode listNode) {
        ListNode head = new ListNode(-1);
        head.next = listNode;
        ListNode first = listNode;
        ListNode firstHead = listNode;
        ListNode second = listNode.next;
        ListNode secondHead = listNode.next;
        while (second != null) {
            first.next = second.next;
            first = second;
            second = second.next;
        }

        ListNode pre = null;
        ListNode next = null;
        second = secondHead;
        while (second != null) {
            next = second.next;
            second.next = pre;
            pre = second;
            second = next;
        }

        first = firstHead;
        second = pre;
        while (second != null) {
            next = first.next;
            first.next = second;
            first = next;
            next = second.next;
            second.next = first;
            second = next;
        }

        System.out.println(head.next);

    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(new int[]{1, 2, 3, 4, 5, 6, 7});
        fold(listNode);
    }
}
