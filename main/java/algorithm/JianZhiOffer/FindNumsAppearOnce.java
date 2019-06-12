package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/4 21:59
 * <p>
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	/*
	方法一：采用set的去重，set的remove方法效率不高，
	后记：经过测试，两种方法效率差不多

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		Set<Integer> set = new HashSet<>();
		for (Integer i : array) {
			if (set.contains(i)) {
				set.remove(i);
			} else {
				set.add(i);
			}
		}
		Integer[] integers = new Integer[2];
		set.toArray(integers);
		num1[0] = integers[0];
		num2[0] = integers[1];

	}
	*/

	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		int temp = 0;
		for (int i : array) {
			temp ^= i;
		}
		int index = findFirstBit(temp);
		for (int i : array) {
			if (isIndexBit1(index, i)) {
				num1[0] ^= i;
			} else {
				num2[0] ^= i;
			}
		}
	}

	private int findFirstBit(int temp) {
		int index = 0;
		while ((1 & temp) != 1) {
			temp = temp >> 1;
			index++;
		}
		return index;
	}

	private boolean isIndexBit1(int index, int i) {
		return (i >> index & 1) == 1;
	}

	public static void main(String[] args) {
		int[] input = {2, 4, 3, 6, 3, 2, 5, 5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce solution = new FindNumsAppearOnce();
		solution.FindNumsAppearOnce(input, num1, num2);
		System.out.println(num1[0]);
		System.out.println(num2[0]);
	}
}
