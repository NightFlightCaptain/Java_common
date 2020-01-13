package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 【最长连续序列】
 * <p>
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/4 15:52
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        // map表示当前点能最大的长度，只需要考虑以当前点为开始或者以当前点为结束
        Map<Integer, Integer> lengthMap = new HashMap<>();
        int numLength = nums.length;
        int maxLength = 0;
        for (int i = 0; i < numLength; i++) {
            if (!lengthMap.containsKey(nums[i])) {
                int leftLength = lengthMap.getOrDefault(nums[i] - 1, 0);
                int rightLength = lengthMap.getOrDefault(nums[i] + 1, 0);

                int thisLength = leftLength + rightLength + 1;
                // 表示从leftLength到当前点再到rightLength全部的点都出现过。
                maxLength = Math.max(maxLength, thisLength);

                // 既然只需要考虑两边的点，那么能不能删除这一行，不能。因为还需要判断该点是否出现过
                lengthMap.put(nums[i], thisLength);

                lengthMap.put(nums[i] - leftLength, thisLength);
                lengthMap.put(nums[i] + rightLength, thisLength);
            }
        }
        return maxLength;
    }

    /* 采用两个Map的解法 */

    private int doubleMapMethod(int[] nums) {
        // asFirst中key是num，value是以num为开始所能到达的最后的位置
        Map<Integer, Integer> asFirst = new HashMap<>();
        // asLast中key是num，value是以num为结束所能到达的最前的位置
        Map<Integer, Integer> asLast = new HashMap<>();

        int longestLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 重复的都不考虑
            if (!asFirst.containsKey(num)) {
                // 当前num的位置
                asFirst.put(num, asFirst.getOrDefault(num + 1, num));
                asLast.put(num, asLast.getOrDefault(num - 1, num));

                longestLength = Math.max(longestLength, asFirst.get(num) - asLast.get(num) + 1);

                if (asFirst.containsKey(num - 1)) {
                    // 如果前一个位置存在，那么当前点能够把该点和前一个点连接起来,只需要改变前一个点能连接到的最远的点 所能到达的最后的点
                    asFirst.put(asLast.get(num - 1), asFirst.get(num));
                    longestLength = Math.max(longestLength, asFirst.get(num - 1) - asLast.get(num - 1) + 1);
                }
                if (asLast.containsKey(num + 1)) {
                    // 如果后一个位置存在，那么当前点能够把该店和后一个点连接起来
                    asLast.put(asFirst.get(num + 1), asLast.get(num));
                    longestLength = Math.max(longestLength, asFirst.get(num + 1) - asLast.get(num + 1) + 1);
                }

            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        LeetCode128 solution = new LeetCode128();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) == 4);
        System.out.println(solution.longestConsecutive(new int[]{}) == 0);
        System.out.println(solution.longestConsecutive(new int[]{1}) == 1);
        System.out.println(solution.longestConsecutive(new int[]{1, 3}) == 1);
        System.out.println(solution.longestConsecutive(new int[]{4, 6, 8, 5}) == 3);
        System.out.println(solution.longestConsecutive(new int[]{1, 2, 0, 1}) == 3);
        System.out.println(solution.longestConsecutive(new int[]{4, 6, 5, 5, 7}) == 4);
    }
}
