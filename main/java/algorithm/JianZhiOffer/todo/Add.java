package algorithm.JianZhiOffer.todo;

/**
 * Author: 小栗旬
 * Date: 2019/3/14 21:45
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
	public int Add(int num1, int num2) {
		int temp1 = num1 > num2 ? num1 : num2;
		int temp2 = num1 <= num2 ? num1 : num2;
		while (temp2 != 0) {
			int sum = temp1 ^ temp2;
			int carry = (temp1&temp2)<<1;
			temp1 = sum;
			temp2 = carry;
		}
		return temp1;
	}
}
