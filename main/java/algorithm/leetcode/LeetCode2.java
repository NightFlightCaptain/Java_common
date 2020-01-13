package algorithm.leetcode;

import algorithm.JianZhiOffer.ListNode;

/**
 * 【两数相加】
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/11/28 11:05
 */
public class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int forehead = 0;
        while (l1 != null || l2 != null || forehead != 0) {
            int val1, val2;
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
                l2 = l2.next;
            }
            int val = val1 + val2 + forehead;
            cur.next = new ListNode(val % 10);
            forehead = val / 10;
            cur = cur.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        LeetCode2 solution = new LeetCode2();
        ListNode l1 = ListNode.getListNode(new int[]{2, 4, 5, 9});
        ListNode l2 = ListNode.getListNode(new int[]{5, 6, 4});
        System.out.println(solution.addTwoNumbers(l1, l2));
    }


}
