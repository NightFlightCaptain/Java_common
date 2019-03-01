package algorithm.JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: 小栗旬
 * Date: 2019/2/28 15:22
 * <p>
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
	public int FirstNotRepeatingChar(String str) {

		char[] chars = str.toCharArray();
		int str_length = chars.length;
		Map<Character,Integer> map = new HashMap<>();
		for (int i =0;i<str_length;i++){
			char c = chars[i];
			if (map.containsKey(c)){
				map.put(c,-1);
			}else {
				map.put(c,i);
			}
		}
		int index =0;
		while (index <str_length){
			int i = map.get(chars[index++]);
			if (i!=-1){
				return i;
			}
		}
		return -1;


//		char[] chars = str.toCharArray();
//		int str_length = chars.length;
//		int[] indexs = new int[52];
//		Arrays.fill(indexs, str_length);
//		for (int i = 0; i < str_length; i++) {
//			if (chars[i] - 97 >= 0) {
//				if (indexs[chars[i] - 97 +26] == str_length) {
//					indexs[chars[i] - 97+26] = i;
//				} else {
//					indexs[chars[i] - 97+26] = -1;
//				}
//			}else {
//				if (indexs[chars[i] - 65] == str_length) {
//					indexs[chars[i] - 65] = i;
//				} else {
//					indexs[chars[i] - 65] = -1;
//				}
//			}
//		}
//		Arrays.sort(indexs);
//		for (int i : indexs) {
//			if (i != -1 && i != str_length) {
//				return i;
//			}
//		}
//		return -1;
	}

	public static void main(String[] args) {
		int[] input = {3334, 3, 3333332};
		FirstNotRepeatingChar solution = new FirstNotRepeatingChar();
		System.out.println(solution.FirstNotRepeatingChar("abcdAefbgBdsdCDABEFGcaseeCDFfg"));

	}
}
