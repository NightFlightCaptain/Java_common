package algorithm.leetcode;

/**
 * 【最大子序和】
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/4 21:18
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            cur += nums[i];
            if (cur < 0) {
                cur = 0;
            } else if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode53 solution = new LeetCode53();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-2, -1, -3 - 5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-2, -1, -3 - 5}));
    }
}
