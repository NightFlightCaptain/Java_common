package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/17 19:59
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		return str.toString().replaceAll(" ", "%20");
	}

	public static void main(String[] args) {
		ReplaceSpace solution = new ReplaceSpace();
		System.out.println(solution.replaceSpace(new StringBuffer("We Are Happy")));
	}
}
