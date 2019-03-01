package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/2/28 13:31
 *
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 *
 */
public class GetUglyNumber {
	public int GetUglyNumber_Solution(int index) {
		if (index== 0){
			return 0;
		}
		ArrayList<Integer> uglyNumbers = new ArrayList<>();
		uglyNumbers.add(1);
		int i2=0,i3=0,i5=0;
		while (uglyNumbers.size()<index){
			int u2 = 2*uglyNumbers.get(i2);
			int u3 = 3*uglyNumbers.get(i3);
			int u5 = 5*uglyNumbers.get(i5);
			int umin = Math.min(u2,Math.min(u3,u5));
			if (umin == u2){
				i2++;
			}
			if (umin == u3){
				i3++;
			}
			if (umin == u5){
				i5++;
			}
			uglyNumbers.add(umin);
		}
		return uglyNumbers.get(index-1);
	}

	public static void main(String[] args) {
		int[] input = {3334,3,3333332};
		GetUglyNumber solution = new GetUglyNumber();
		System.out.println(solution.GetUglyNumber_Solution(14));
	}
}
