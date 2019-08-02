package algorithm.JianZhiOffer.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Author: 小栗旬
 * Date: 2019/8/2 20:12
 * <p>
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * <p>
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {

	/**
	 * 链接：https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?f=discussion
	 来源：牛客网

	 对于无重复值的情况
	 *
	 * 固定第一个字符，递归取得首位后面的各种字符串组合；
	 * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
	 * *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
	 *
	 * 假如有重复值呢？
	 * *由于全排列就是从第一个数字起，每个数分别与它后面的数字交换，我们先尝试加个这样的判断——如果一个数与后面的数字相同那么这两个数就不交换了。
	 * 例如abb，第一个数与后面两个数交换得bab，bba。然后abb中第二个数和第三个数相同，就不用交换了。
	 * 但是对bab，第二个数和第三个数不 同，则需要交换，得到bba。
	 * 由于这里的bba和开始第一个数与第三个数交换的结果相同了，因此这个方法不行。
	 *
	 * 换种思维，对abb，第一个数a与第二个数b交换得到bab，然后考虑第一个数与第三个数交换，此时由于第三个数等于第二个数，
	 * 所以第一个数就不再用与第三个数交换了。再考虑bab，它的第二个数与第三个数交换可以解决bba。此时全排列生成完毕！
	 *
	 *
	 */
	ArrayList<String> result = new ArrayList<>();
	TreeSet<String> set = new TreeSet<>();

	public ArrayList<String> Permutation(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		helper(chars,0);
		result.addAll(set);
		return result;
	}

	private void helper(char[] chars, int index) {
		int length = chars.length;
		if (length - 1 == index) {
			set.add(new String(chars));
		} else {
			for (int i = index ; i < length; i++) {
				swap(chars, index, i);
				helper(chars, index + 1);
				swap(chars,i,index);
			}
		}
	}

	private void swap(char[] chars, int index1, int index2) {
		char temp = chars[index1];
		chars[index1] = chars[index2];
		chars[index2] = temp;
	}

	public static void main(String[] args) {
		Permutation solution = new Permutation();
		System.out.println(solution.Permutation("abb"));
	}
}
