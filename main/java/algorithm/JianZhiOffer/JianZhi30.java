package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/2/26 18:13
 */
public class JianZhi30 {

	public int FindGreatestSumOfSubArray(int[] array) {
		int length = array.length;
		int[] sums = new int[length];
		sums[0] = array[0];
		int max_sum = sums[0];
		for (int i = 1; i < length; i++) {
			if (sums[i - 1] >= 0) {
				sums[i] = sums[i - 1] + array[i];
			} else {
				sums[i] = array[i];
			}
			max_sum = sums[i]>max_sum? sums[i]:max_sum;

		}
		return max_sum;
	}

	public static void main(String[] args) {
		JianZhi30 jianZhi30 = new JianZhi30();
		int[] input = {-11,-2,-3,-9,-8};
		System.out.println(jianZhi30.FindGreatestSumOfSubArray(input));
	}
}
