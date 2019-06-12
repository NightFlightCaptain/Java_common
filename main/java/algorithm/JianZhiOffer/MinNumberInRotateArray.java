package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/4/19 17:53
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * <p>
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
	public int minNumberInRotateArray(int[] array) {
		int length = array.length;
		if (length == 0) {
			return 0;
		}

		int index = 1;
		while (index<length-1){
			if (array[index-1]>array[index]){
				return array[index];
			}
			index++;
		}
		return array[0];
	}

	public static void main(String[] args) {
		MinNumberInRotateArray solution = new MinNumberInRotateArray();
		int[] a = {1};
		System.out.println(solution.minNumberInRotateArray(a));
	}
}
