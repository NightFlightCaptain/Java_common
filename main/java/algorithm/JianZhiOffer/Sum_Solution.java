package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/14 21:42
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
	public int Sum_Solution(int n) {
		int m =0;
		boolean b  = (n != 0) && (m==(n = n + Sum_Solution(n - 1)));
		return n;
	}

	public static void main(String[] args) {
		Sum_Solution solution = new Sum_Solution();
		System.out.println(solution.Sum_Solution(1));
	}
}
