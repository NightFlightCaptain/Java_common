package algorithm.JianZhiOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author: 小栗旬
 * Date: 2019/2/28 12:44
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
	public String PrintMinNumber(int [] numbers) {
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1= o1+o2;
				String s2= o2+o1;
				return s1.compareTo(s2);


//				int firstLength = o1.length();
//				int secondLength = o2.length();
//				int minLength = Math.min(firstLength,secondLength);
//				int i =0;
//
//				while (i<minLength){
//					char c1 = o1.charAt(i);
//					char c2 = o2.charAt(i);
//					if (c1!=c2){
//						return c1-c2;
//					}
//				}
//
//				if (firstLength < secondLength){
//					return o1.charAt(minLength-1) > o2.charAt(minLength)?1:-1;
//				}else if (firstLength > secondLength){
//					return o1.charAt(minLength) > o2.charAt(minLength-1)?1:-1;
//				}else {
//					return 0;
//				}

			}
		};
		int length = numbers.length;
		String[] strings = new String[length];
		for (int i =0;i<length;i++){
			strings[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(strings,comparator);
		StringBuilder sb = new StringBuilder();
		for (String s:strings){
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] input = {3334,3,3333332};
		PrintMinNumber pmn = new PrintMinNumber();
		System.out.println(pmn.PrintMinNumber(input));
	}
}
