package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【最长上升子序列】
 * <p>
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/2/11 19:24
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int[] dp = new int[length];
        int[] ends = new int[length + 1];
        Arrays.fill(dp, 1);
        ends[1] = nums[0];

        int maxCount = 1;
        for (int i = 1; i < length; i++) {
            int index = 0;
            for (int j = maxCount; j > 0; j--) {
                if (nums[i] > ends[j]) {
                    dp[i] = j + 1;
                    index = j;
                    if (j == maxCount) {
                        maxCount++;
                    }
                    break;
                }
            }
            ends[index + 1] = nums[i];
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LeetCode300 solution = new LeetCode300();
        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
        System.out.println(solution.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
