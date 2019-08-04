package algorithm.CC150;

/**
 * Author: 小栗旬
 * Date: 2019/8/3 22:03
 *
 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。

 给定一个string iniString，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。

 测试样例：
 "aeiou"
 返回：True
 "BarackObama"
 返回：False
 */
public class Different {
	public boolean checkDifferent(String iniString) {
		int length = iniString.length();
		for (int i =0;i<length;i++){
			char c= iniString.charAt(i);
			if (iniString.indexOf(c,i+1)!=-1){
				return false;
			}
		}
		return true;
	}
	//ASCII码总共有256个，前128个为常用，后128个不常用

	public static void main(String[] args) {
		Different different = new Different();
		System.out.println(different.checkDifferent("aeiou"));
	}
}
