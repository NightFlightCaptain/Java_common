package algorithm.JianZhiOffer;

import java.util.ArrayList;

/**
 * Author: 小栗旬
 * Date: 2019/3/6 21:36
 * <p>
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class FindNumbersWithSum {
//	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
//		int length = array.length;
//		ArrayList<Integer> arrayList = new ArrayList<>();
//		for (int i = length - 1; i >= 0; i--) {
//			if (!arrayList.isEmpty()) {
//				break;
//			}
//			int remainder = sum - array[i];
//			for (int j = i - 1; remainder >= 0 && j >= 0; j--) {
//				if (remainder == array[j]) {
//					arrayList.add(remainder);
//					arrayList.add(array[i]);
//				}
//			}
//		}
//		return arrayList;
//	}

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int length = array.length;
		ArrayList<Integer> arrayList = new ArrayList<>();
		if (length<2){
			return arrayList;
		}
		int head = 0;
		int tail = length-1;
		int count = array[head]+array[tail];
		while (head<tail && count!=sum){
			if (count > sum){
				tail--;
			}else {
				head++;
			}
			count = array[head]+array[tail];
		}
		if (head<tail){
			arrayList.add(array[head]);
			arrayList.add(array[tail]);
		}
		return arrayList;
	}

	public static void main(String[] args) {
		int[] input = {1,2,4,7,11,15};

		FindNumbersWithSum solution = new FindNumbersWithSum();
		System.out.println(solution.FindNumbersWithSum(input, 15));
	}
}
