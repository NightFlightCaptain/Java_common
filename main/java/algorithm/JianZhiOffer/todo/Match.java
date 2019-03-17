package algorithm.JianZhiOffer.todo;

/**
 * Author: 小栗旬
 * Date: 2019/3/17 10:58
 * <p>
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Match {
	public boolean match(char[] str, char[] pattern) {
		return matchCore(str, pattern, 0, 0);
	}

	private boolean matchCore(char[] str, char[] pattern, int pStart, int sStart) {
		if (sStart == str.length&&pStart == pattern.length) {
			return true;
		}
		if (sStart != str.length && pStart == pattern.length) {
			return false;
		}

		if (pStart < pattern.length - 1 && pattern[pStart + 1] == '*') {
			if ((sStart!=str.length)&&(str[sStart] == pattern[pStart] || pattern[pStart] == '.')) {
				pattern[pStart] = str[sStart];
				return matchCore(str, pattern, pStart + 2, sStart)
						|| matchCore(str, pattern, pStart, sStart + 1)
						|| matchCore(str, pattern, pStart + 2, sStart + 1);
			} else {
				return matchCore(str, pattern, pStart + 2, sStart);
			}
		} else {
			if ((sStart!=str.length)&&(str[sStart] == pattern[pStart] || pattern[pStart] == '.')) {
				return matchCore(str, pattern, pStart + 1, sStart + 1);
			} else {
				return false;
			}
		}

	}

	public static void main(String[] args) {
		Match solution = new Match();
		System.out.println(solution.match("".toCharArray(), ".".toCharArray()));
	}
}
