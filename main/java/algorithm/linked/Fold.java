package algorithm.linked;

import algorithm.JianZhiOffer.ListNode;

/**
 * @author: 小栗旬
 * @Date: 2020/3/6 21:48
 */
public class Fold {
    /*单向链表，对折成1 ->n->2->n-1->3…… */

    private static void fold(ListNode listNode) {
        ListNode first = listNode.next;
        ListNode second = listNode;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
        }
        ListNode cur = second.next;
        second.next=null;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        first = listNode;
        second = pre;
        while (second!=null){
            next = first.next;
            first.next = second;
            first =second;
            second = next;
        }
        System.out.println(listNode);

    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(new int[]{1,2,3,4,5,6,7});
        fold(listNode);
        ListNode listNode2 = ListNode.getListNode(new int[]{1,2,3,4,5,6,7,8});
        fold(listNode2);
    }
}
