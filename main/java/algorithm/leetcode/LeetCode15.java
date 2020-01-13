package algorithm.leetcode;

import java.util.*;

/**
 * 【三数之和】
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/1 17:00
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {

        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {

            int target = -nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                    while (left > 0 && left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                } else {
                    right--;
                    while (right < length - 1 && left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }

            }
            while (i < length - 3 && nums[i] == nums[i + 1]) {
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode15 solution = new LeetCode15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
        System.out.println(solution.threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));

    }
}
