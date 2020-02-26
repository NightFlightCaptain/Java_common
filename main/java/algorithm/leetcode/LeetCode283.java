package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【移动零】
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/15 18:19
 */
public class LeetCode283 {
    public void moveZeroes(int[] nums) {
        int firstZeroIndex = 0;
        for (int i = firstZeroIndex ; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, firstZeroIndex, i);
                firstZeroIndex++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }



    public static void main(String[] args) {
        LeetCode283 solution = new LeetCode283();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 0, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 1, 1, 0, 0};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 3, 5, 9, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
