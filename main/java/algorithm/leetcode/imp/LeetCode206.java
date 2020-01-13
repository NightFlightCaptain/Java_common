package algorithm.leetcode.imp;

import algorithm.JianZhiOffer.ListNode;

/**
 * 【反转链表】
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/13 19:22
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        return recursiveMethod(head);
//        return iterateMethod(head);
    }

    private ListNode iterateMethod(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode recursiveMethod(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        LeetCode206 solution = new LeetCode206();
        System.out.println(solution.reverseList(ListNode.getListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println(solution.reverseList(ListNode.getListNode(new int[]{1})));
        System.out.println(solution.reverseList(ListNode.getListNode(new int[]{})));
    }


}
