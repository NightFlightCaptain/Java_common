/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。

现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
示例:

输入: [3,1,5,8]
输出: 167 
解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 
 */
package algorithm.leetcode;
import java.util.Arrays;

public class LeetCode312 {

	public static void main(String[] args) {
		int[] nums = {3,1,5,8};
		System.out.println(sort(nums));
	}
	

	private static int sort(int[] nums) {
		int[][] dp = new int[nums.length+2][nums.length+2];
		int[] newNums = new int[nums.length+2];
		Arrays.fill(newNums, 1);
		System.arraycopy(nums, 0, newNums, 1, nums.length);
		for (int len = 0; len < nums.length; len++) {
			for (int left = 1; left +len<= nums.length; left++) {
				int right = left + len;
				for (int j = left; j <=right; j++) {
					dp[left][right] = Math.max(dp[left][right],newNums[left-1]*newNums[j]*newNums[right+1]+dp[left][j-1]+dp[j+1][right] );
					System.out.println("left: "+left+" right: "+right+" j: "+j +"   dp["+left+"]["+right+"] = "+dp[left][right]);
					
				}
			}
		}
		return dp[1][nums.length];
	}
}

