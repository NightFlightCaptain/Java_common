package algorithm.JianZhiOffer.todo;

/**
 * Author: 小栗旬
 * Date: 2019/3/18 20:01
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class IsNumeric {
	public boolean isNumeric(char[] str) {
		int length = str.length;
		boolean dotAppeared = false;
		boolean eAppeared = false;
		boolean signAppeared = false;

		for (int i = 0; i < length; i++) {
			char c = str[i];
			if (c == 'e' || c == 'E') {
				if (i == length - 1) {
					return false;
				}
				if (eAppeared) {
					return false;
				}
				eAppeared = true;
			} else if (c == '+' || c == '-') {
				if ((signAppeared ||  i!=0) && (str[i-1]!='e' ||str[i-1]!='E')){
					return false;
				}
				signAppeared = true;
			}else if (c=='.'){
				if (eAppeared || dotAppeared){
					return false;
				}
				dotAppeared=true;
			}else if (!isInteger(c)){
				return false;
			}
		}
		return true;
	}

	private boolean isInteger(char c) {
		if (c - '0' >= 0 && c - '0' <= 9) {
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		IsNumeric solution = new IsNumeric();
		String[] strings = {"+100", "5e2", "-123", "3.1416", "-1E-16", "12e", "1a3.14", "1.2.3", "+-5", "12e+4.3"};
		for (String s : strings) {
			System.out.println(solution.isNumeric(s.toCharArray()));
		}
	}
}
