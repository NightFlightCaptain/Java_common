package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【下一个排列】
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/2 14:31
 */
public class LeetCode31 {
    /**
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int rightIndex = length - 1;
        //从右到左找到第一个大于前一个数的数的下标
        while (rightIndex > 0 && nums[rightIndex] <= nums[rightIndex - 1]) {
            rightIndex--;
        }
        //将从该下标到最后的数组反转
        reverse(nums, rightIndex);

        if (rightIndex == 0) {
            return;
        }
        int swapIndex = rightIndex - 1;
        //记左边的数为A,从当前开始到结尾第一个比A大的数，将其和A交换
        while (nums[rightIndex] <= nums[swapIndex]) {
            rightIndex++;
        }
        swap(nums, swapIndex, rightIndex);
        System.out.println(Arrays.toString(nums));

    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int[] nums, int start) {
        int length = nums.length;
        int i = 0;
        while (((length - start) >> 1) > i) {
            swap(nums, start + i, length - i - 1);
            i++;
        }
    }

    public static void main(String[] args) {
        LeetCode31 solution = new LeetCode31();
        solution.nextPermutation(new int[]{1, 2, 3});
        solution.nextPermutation(new int[]{1, 3, 2});
        solution.nextPermutation(new int[]{2, 1, 3});
        solution.nextPermutation(new int[]{3, 2, 1});
        solution.nextPermutation(new int[]{1,5,1});
        solution.nextPermutation(new int[]{1,1,1});
        solution.nextPermutation(new int[]{1,1,2,2});
    }

}
