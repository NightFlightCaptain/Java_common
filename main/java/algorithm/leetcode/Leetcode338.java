package algorithm.leetcode;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/2/19 13:58
 *
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
public class Leetcode338 {
	public boolean isPowerOfFour(int num) {
		if((num < 0) || (num & (num - 1))==0){
			return false;
		}
		return (num & 0x55555555) !=0;
	}
	public int[] countBits(int num) {
		int[] counts = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			//分i为奇数和偶数分别讨论后再合并
			counts[i] = counts[i >>1] + (i & 1);
		}
		return counts;

//		int index = 0;
//		for (int i = 0; i <= num; i++) {
//			int count = 0;
//			if (i < 2) {
//				count = i;
//				index = i;
//			} else {
//				count = counts[i - index - 1] + 1;
//			}
//			counts[i] = count;
//			if (counts[i] > counts[index]) {
//				index = i;
//			}
//		}
//		return counts;


//		for (int i =0;i<=num;i++){
//			int count =0;
//			int a = i;
//			while (a>0){
//				if ((a&1)==1){
//					count++;
//				}
//				a=a>>1;
//			}
//			counts[i]=count;
//		}
//		return counts;
	}

	public static void main(String[] args) {
		int num = 30;
		System.out.println(Arrays.toString(new Leetcode338().countBits(num)));
	}
}
