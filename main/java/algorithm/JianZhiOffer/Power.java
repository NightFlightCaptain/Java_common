package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/6/12 19:44
 * <p>
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
	public double Power(double base, int exponent) {
		double c = base;
		double result = 1;
		int stage = exponent;
		if (exponent < 0) {
			exponent = -exponent;
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1) {
				result = result * c;
			}
			c = c * c;
			exponent >>= 1;
		}
		return stage>0?result:1/result;
	}

	public static void main(String[] args) {
		Power solution = new Power();
		System.out.println(solution.Power(1.2, 9));
	}
}
