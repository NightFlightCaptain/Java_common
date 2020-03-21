package algorithm.leetcode;

import algorithm.JianZhiOffer.ListNode;

/**
 * 【两数相加 II】
 * <p>
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * <p>
 * <p>
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶:
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例:
 * <p>
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * @author: 小栗旬
 * @Date: 2020/3/19 15:57
 */
public class LeetCode445 {

    public static void main(String[] args) {
        LeetCode445 solution = new LeetCode445();
        ListNode head = solution.addTwoNumbers(ListNode.getListNode(new int[]{7,2,4,3}),ListNode.getListNode(new int[]{5,6,4}));
        System.out.println(head);
    }
    int pre = 0;

    /*
    1、先反转链表，再相加
    2、如果不能反转链表，就补全链表长度，使用递归计算。
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res1 = l1, res2 = l2;
        int len1 = 0, len2 = 0;
        while (l1 != null) {
            len1++;
            l1 = l1.next;
        }
        while (l2 != null) {
            len2++;
            l2 = l2.next;
        }
        ListNode temp;
        while (len1 < len2) {
            temp = new ListNode(0);
            temp.next = res1;
            res1 = temp;
            len1++;
        }

        while (len1 > len2) {
            temp = new ListNode(0);
            temp.next = res2;
            res2 = temp;
            len2++;
        }
        ListNode head =  add(res1, res2);
        if (pre == 1){
            temp = new ListNode(pre);
            temp.next = head;
            head = temp;
        }
        return head;


    }


    private ListNode add(ListNode l1, ListNode l2) {
        int curSum = l1.val + l2.val;
        if (l1.next == null || l2.next == null) {
            ListNode head;
            if (curSum >= 10) {
                pre = 1;
                head = new ListNode(curSum % 10);
            } else {
                head = new ListNode(curSum);
            }
            return head;
        }

        ListNode head = add(l1.next,l2.next);
        curSum+=pre;
        if (curSum >= 10) {
            pre =1;
            ListNode temp = new ListNode(curSum%10);
            temp.next = head;
            return temp;
        }else {
            pre = 0;
            ListNode temp = new ListNode(curSum);
            temp.next = head;
            return temp;
        }
    }
}
