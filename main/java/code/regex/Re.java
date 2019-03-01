package code.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: 小栗旬
 * Date: 2019/2/26 21:53
 */
public class Re {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\d+");
		System.out.println();
		//String.split("正则表达式");
		String[] strings = pattern.split("22bb23");
		System.out.println(Arrays.toString(strings));
		//matcher.matches()是否整个字符串与正则相匹配
		//matcher.lookingAt()判断字符串是否从开头就与正则相匹配
		//matcher.find()判断字符串中是否有与正则相匹配的
		//matcher的start() end() group()都必须与以上三个方法相匹配，

		Matcher matcher = pattern.matcher("22bb23");
		while (matcher.find()) {
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());
		}
	}

}
