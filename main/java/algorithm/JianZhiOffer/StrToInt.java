package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/16 8:59
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * <p>
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * <p>
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * <p>
 * 输入
 * +2147483647
 * 1a33
 * <p>
 * 输出
 * 2147483647
 * 0
 */
public class StrToInt {
	public int StrToInt(String str) {
		char[] chars = str.toCharArray();
		int length = chars.length;
		if (length == 0) {
			return 0;
		}
		int startIndex = 0;
		int isPos = 1;
		long res = 0;
		if (chars[0] == '+') {
			startIndex = 1;
		} else if (chars[0] == '-') {
			startIndex = 1;
			isPos = -1;
		}
//		for (int i = startIndex; i < length; i++) {
//			int c = chars[i] - '0';
//			if (c > 9 || c < 0) {
//				return 0;
//			}
//			res = res * 10 + c;
//		}
		for (int i = startIndex; i < length; i++) {
			int c = chars[i] - '0';
			if (c > 9 || c < 0) {
				return 0;
			}
			res = (res << 1) + (res << 3) + c;
		}
		return (int) res * isPos;
	}

	public static void main(String[] args) {
		StrToInt solution = new StrToInt();
		System.out.println(solution.StrToInt("2147483650"));
	}
}
