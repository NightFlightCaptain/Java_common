package algorithm.JianZhiOffer;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/6/12 20:02
 * <p>
 * 代码的完整性-调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
	public void reOrderArray(int[] array) {
		int length = array.length;
		int count = length;
		for (int i = 0; i < count; ) {
			if (!isOdd(array[i])){
				int temp = array[i];
				for (int j=i;j<array.length-1;j++){
					array[j]=array[j+1];
				}
				array[length-1]=temp;
				count--;
			}else {
				i++;
			}

		}
	}

	private static boolean isOdd(int num){
		if ((num&1)!=1){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ReOrderArray solution = new ReOrderArray();
		int[] array = {1,9,7,8,5,4,6,3,2,12,9};
		solution.reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
}
