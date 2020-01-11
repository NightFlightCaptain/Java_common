package algorithm.leetcode;

/**
 * 【乘积最大子序列】
 * <p>
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/11 15:53
 */
public class LeetCode152 {
    /* 维护最大的和最小值，如果乘上一个负数，那么最大最小值就会更改 */

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tem = max;
            max = Math.max(num, Math.max(num * max, num * min));
            min = Math.min(num, Math.min(num * tem, num * min));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode152 solution = new LeetCode152();
        System.out.println(solution.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(solution.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(solution.maxProduct(new int[]{-2}));
    }
}
