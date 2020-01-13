package algorithm.leetcode.competition.week171;

import java.util.Arrays;

/**
 * 【1317 将整数转换为两个无零整数的和】
 * <p>
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * <p>
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * <p>
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 * <p>
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：[2,9]
 * 示例 3：
 * <p>
 * 输入：n = 10000
 * 输出：[1,9999]
 * 示例 4：
 * <p>
 * 输入：n = 69
 * 输出：[1,68]
 * 示例 5：
 * <p>
 * 输入：n = 1010
 * 输出：[11,999]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^4
 *
 * @author: 小栗旬
 * @Date: 2020/1/12 10:30
 */
public class LeetCode5307 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (!hasZero(i) && !hasZero(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{};
    }

    private boolean hasZero(int m) {
        while (m >= 10) {
            if (m % 10 == 0) {
                return true;
            }
            m = m / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode5307 solution = new LeetCode5307();
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(69)));
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(1010)));
    }
}
