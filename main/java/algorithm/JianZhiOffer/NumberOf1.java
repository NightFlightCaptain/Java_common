package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/20 10:00
 */
public class NumberOf1 {
	public int NumberOf1(int n) {
		int count = 0;
		for (int i = 0; i <= 31; i++) {
			count += ((n >> i) & 1);
		}
		return count;
	}

	public static void main(String[] args) {
		NumberOf1 solution = new NumberOf1();
		System.out.println(solution.NumberOf1(1));

	}
}
