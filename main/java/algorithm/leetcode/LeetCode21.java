package algorithm.leetcode;

import algorithm.JianZhiOffer.ListNode;

/**
 * 【合并两个有序链表】
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/1 19:48
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        ListNode list1 = l1;
        ListNode list2 = l2;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curNode.next = list2;
                list2 = list2.next;
            } else {
                curNode.next = list1;
                list1 = list1.next;
            }
            curNode = curNode.next;
        }

        while (list1 != null) {
            curNode.next = list1;
            curNode = curNode.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            curNode.next = list2;
            curNode = curNode.next;
            list2 = list2.next;
        }
        return head.next;

    }

    public static void main(String[] args) {
        LeetCode21 solution = new LeetCode21();
        ListNode l1 = ListNode.getListNode(new int[]{});
        ListNode l2 = ListNode.getListNode(new int[]{1,3,4});
        System.out.println(solution.mergeTwoLists(l1, l2));
    }
}
