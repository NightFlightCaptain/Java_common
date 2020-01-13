package algorithm.leetcode.competition.weekdouble17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【1313 解压缩编码列表】
 * <p>
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * <p>
 * 考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。
 * <p>
 * 请你返回解压后的列表。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 *
 * @author: 小栗旬
 * @Date: 2020/1/11 22:38
 */
public class LeetCode5143 {
    public int[] decompressRLElist(int[] nums) {
        int length = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length ; i+=2) {
            int a = nums[i];
            int b = nums[i + 1];
            for (int j = 0; j < a; j++) {
                list.add(b);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode5143 solution = new LeetCode5143();
        System.out.println(Arrays.toString(solution.decompressRLElist(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.decompressRLElist(new int[]{})));
    }
}
