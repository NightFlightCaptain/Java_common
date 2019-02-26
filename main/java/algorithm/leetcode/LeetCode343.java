package algorithm.leetcode;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/2/20 12:56
 * <p>
 * <p>
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class LeetCode343 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.integerBreak(10));

	}
}

class Solution {
	public int integerBreak(int n) {
		int[] caches = new int[n + 1];
		caches[0] = 0;
		caches[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				caches[i] = Math.max(caches[i],Math.max(j,caches[j])*Math.max(i-j,caches[i-j]));
			}
		}
		System.out.println(Arrays.toString(caches));
		return caches[n];
	}
}
