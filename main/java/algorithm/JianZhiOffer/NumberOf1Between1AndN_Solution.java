package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/2/26 18:32
 */
public class NumberOf1Between1AndN_Solution {
	public int NumberOf1Between1AndN_Solution(int n) {
		int count = 0;
		for (int i = 1; i <= n; i *= 10) {
			int a = n / i;
			int b = n % i;
			int k = a % 10;

			count += (a / 10) * i;
			count+= k>=2?i:0;
			count+=k==1?(b+1):0;
		}
		return count;
	}

	public static void main(String[] args) {
		NumberOf1Between1AndN_Solution solution = new NumberOf1Between1AndN_Solution();
		int[] input = {-11, -2, -3, -9, -8};
		System.out.println(solution.NumberOf1Between1AndN_Solution(10));
	}
}
