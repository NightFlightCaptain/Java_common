package algorithm.JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/2/21 20:31
 */
public class TheSmallestNumbers {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

		ArrayList<Integer> rs = new ArrayList<>();
		int[] re = new int[k+1];
		if (input.length < k){
			return rs;
		}
		System.arraycopy(input,0,re,0,k);
//		Arrays.sort(re);
		for (int i = k;i<input.length;i++){
			re[k]=input[i];
			Arrays.sort(re);
		}
		for (int m=0;m<k;m++){
			rs.add(re[m]);
		}
		return rs;
	}

	public static void main(String[] args) {
		int[] input = {4,5,1,6,2,7,3,8};
		System.out.println(new TheSmallestNumbers().GetLeastNumbers_Solution(input, 10));
	}
}
