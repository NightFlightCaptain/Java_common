package algorithm.leetcode.imp;

import algorithm.JianZhiOffer.ListNode;

/**
 * 【回文链表】
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/14 13:57
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        ListNode pre = new ListNode(-1);
        ListNode next = slow.next;
        // 使用快慢节点，找到中间节点，并在这个过程中把中间节点前面的节点全部反转
        // 每次循环pre及其之前的链表都反转了，slow表示的是第一个没有被反转的节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow.next = pre;
            pre = slow;
            slow = next;
            next = next.next;
        }

        // 如果fast!=null表示链表为奇数，slow正处于正中间的位置上。
        // 如果fast==null表示链表为偶数，slow处于下半部分
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;

    }

    public static void main(String[] args) {
        LeetCode234 solution = new LeetCode234();
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1, 2, 2, 1})));
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1, 2, 1})));
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1, 2, 3, 2, 1})));
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1, 2, 3, 1})) == false);
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1})));
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1, 2, 3})) == false);
        System.out.println(solution.isPalindrome(ListNode.getListNode(new int[]{1, 2, 3, 3, 2, 1, 3})) == false);
    }
}
