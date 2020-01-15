package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【寻找重复数】
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/15 18:49
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        return doublePointSolution(nums);
    }

    /* 快慢指针，将nums看成链表。LeetCode142
    将nums中的值看作是指向下一个数的指针。nums中相同的值，相当于链表中有环，找到环的位置 */

    /*这种方法非常的不常规，适用场景也很少*/

    private int doublePointSolution(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int before = 0;
        int after = slow;
        while (before != after) {
            before = nums[before];
            after = nums[after];
        }
        return before;
    }

    /* 二分方法 */

    private int binarySearchSolution(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = length - 1;
        while (left < right) {
            // 找到中间值
            int mid = (right + left) >> 1;
            // 统计小于等于该中间值的数量
            long count = Arrays.stream(nums).filter(o -> o <= mid).count();
            // 如果统计数量小于等于中间值，说明左边是正常的
            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LeetCode287 solution = new LeetCode287();
        System.out.println(solution.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(solution.findDuplicate(new int[]{3, 1, 3, 4, 3}));
        System.out.println(solution.findDuplicate(new int[]{2, 1, 2, 4, 3}));
        System.out.println(solution.findDuplicate(new int[]{1, 1, 2, 3}));
    }
}
