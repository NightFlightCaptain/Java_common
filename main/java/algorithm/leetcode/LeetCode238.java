package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【除自身以外数组的乘积】
 * <p>
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/15 15:09
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        output[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }
        int leftProduct = nums[0];
        for (int i = 1; i < length; i++) {
            output[i] = output[i] * leftProduct;
            leftProduct *= nums[i];
        }
        return output;
    }

    public static void main(String[] args) {
        LeetCode238 solution = new LeetCode238();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{4})));
    }
}
