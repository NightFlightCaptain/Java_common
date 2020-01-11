package algorithm.leetcode.todo;

import algorithm.JianZhiOffer.ListNode;

/**
 * 【排序链表】
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/10 22:46
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        return recursiveMergeSort(head);
    }


    /* 递归，但这种方法实际上并非常数级空间复杂度，每一次递归都会用到空间，是logn的空间复杂度 */

    private ListNode recursiveMergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oneStep = head;
        /* 这个地方非常关键，后面是根据oneStep的位置来进行分割，oneStep的后面为后半部分，oneStep本身是归于前半部分的 */
        ListNode twoStep = head.next;
        while (twoStep != null && twoStep.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        ListNode temp = oneStep.next;
        oneStep.next = null;
        ListNode left = recursiveMergeSort(head);
        ListNode right = recursiveMergeSort(temp);
        ListNode pre = new ListNode(-1);
        ListNode res = pre;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        while (left != null) {
            pre.next = left;
            left = left.next;
            pre = pre.next;
        }

        while (right != null) {
            pre.next = right;
            right = right.next;
            pre = pre.next;
        }
        return res.next;
    }


    public static void main(String[] args) {
        LeetCode148 solution = new LeetCode148();
        System.out.println(solution.sortList(ListNode.getListNode(new int[]{4, 2, 1, 3})));
        System.out.println(solution.sortList(ListNode.getListNode(new int[]{-1, 5, 3, 4, 0})));
        System.out.println(solution.sortList(ListNode.getListNode(new int[]{-1, 5})));
        System.out.println(solution.sortList(ListNode.getListNode(new int[]{-1})));
        System.out.println(solution.sortList(ListNode.getListNode(new int[]{})));
    }
}
