package algorithm.leetcode;

import algorithm.JianZhiOffer.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 【合并K个排序链表】
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/1 21:17
 */
public class LeetCode23 {
    /**
     * 时间复杂度为O(n*logk) n为所有ListNode里面元素个数和，k为链表数
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        PriorityQueue<Node> headNodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        int nullCount = 0;
        for (int i = 0; i < length; i++) {
            if (lists[i] != null) {
                headNodes.add(new Node(i, lists[i].val));
            }else {
                nullCount++;
            }
        }
        while (nullCount < length) {
            Node node = headNodes.poll();
            cur.next = lists[node.listIndex];
            cur = cur.next;
            if (lists[node.listIndex].next != null) {
                lists[node.listIndex] = lists[node.listIndex].next;
                headNodes.add(new Node(node.listIndex, lists[node.listIndex].val));
            } else {
                nullCount++;
            }
        }
        return head.next;
    }

    class Node {
        int listIndex;
        int value;

        public Node(int listIndex, int value) {
            this.listIndex = listIndex;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LeetCode23 solution = new LeetCode23();
        ListNode list1 = ListNode.getListNode(new int[]{1,4,5});
        ListNode list2 = ListNode.getListNode(new int[]{1,3,4});
        ListNode list3 = ListNode.getListNode(new int[]{2,6});
        ListNode[] lists = {list1,list2,list3};
        System.out.println(solution.mergeKLists(lists));
    }
}
