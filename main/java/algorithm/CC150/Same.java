package algorithm.CC150;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/8/4 8:02
 */
public class Same {
	public boolean checkSam(String stringA, String stringB) {
		// write code here
		int lengthA = stringA.length();
		int lengthB = stringB.length();
		if (lengthA != lengthB){
			return false;
		}
		int[] countA = new int[128];
		int[] countB = new int[128];
		for (int i =0;i<lengthA;i++){
			countA[stringA.charAt(i)]++;
			countB[stringB.charAt(i)]++;
		}
		return Arrays.equals(countA,countB);
	}

	public static void main(String[] args) {
		Same same= new Same();
		System.out.println(same.checkSam("Here you are", "Are you here"));
	}
}
