package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/16 9:42
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Duplicate {
	/**
	 * @param numbers     an array of integers
	 * @param length      the length of array numbers
	 * @param duplication (Output) the duplicated number in the array number,length of duplication array is 1,
	 *                    so using duplication[0] = ? in implementation;
	 *                    Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
	 *                    这里要特别注意~返回任意重复的一个，赋值duplication[0]
	 * @return true if the input is valid, and there are some duplications in the array number
	 * otherwise false
	 */
	public boolean duplicate(int numbers[], int length, int[] duplication) {
//		boolean[] duplicated = new boolean[length];
//		for (int i =0;i<length;i++){
//			if (duplicated[numbers[i]]){
//				duplication[0] =numbers[i];
//				return true;
//			}
//			duplicated[numbers[i]]=true;
//		}
//		return false;

		for (int i = 0; i < length; i++) {
			int index = numbers[i];
			if (index >= length) {
				index -= length;
			}
			if (numbers[index] > length) {
				duplication[0] = index;
				return true;
			}
			numbers[index]+=length;
		}
		return false;
	}

	public static void main(String[] args) {
		Duplicate solution = new Duplicate();
		int[] input = {2, 3, 1, 0, 2, 5, 3};
		int[] output = new int[]{-1};
		System.out.println(solution.duplicate(input, input.length, output));
		System.out.println(output[0]);
	}
}
