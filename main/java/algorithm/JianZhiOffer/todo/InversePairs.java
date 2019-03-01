package algorithm.JianZhiOffer.todo;

import java.util.Arrays;

/**
 * Author: 小栗旬
 * Date: 2019/2/28 15:56
 * <p>
 * <p>
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * <p>
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * <p>
 * 对于%50的数据,size<=10^4
 * <p>
 * 对于%75的数据,size<=10^5
 * <p>
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class InversePairs {
	int count = 0;
	public int InversePairs(int[] array) {
		int length = array.length;
		int[] sortedArray = Arrays.copyOf(array, array.length);
		Arrays.sort(sortedArray);
		int origin_index;
		int new_index = 0;
		int count = 0;
		while (new_index < length) {
			origin_index = 0;
			while (array[origin_index] != sortedArray[new_index]) {
				if (array[origin_index] > sortedArray[new_index]) {
					count++;
				}
				origin_index++;
			}
			new_index++;
		}
		return count % 1000000007;
	}

	private void inversePairsCore(int[] array, int start, int end) {
		if (start >= end) {
		}
		int mid = (start + end) >> 1;
		inversePairsCore(array, start, mid);
		inversePairsCore(array, mid + 1, end);
		merge(array, start, mid, end);
	}

	private void merge(int[] array, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (i <= mid && j <= end) {
			if (array[i] <= array[j]) {
				tmp[k++]=array[i++];
			}else {
				tmp[k++] =array[j++];
				count++;
			}
		}
		while (i<=mid){
			tmp[k++] = array[i++];
		}
		while (j<=end){
			tmp[k++]=array[j++];
		}
		for (k=0;k<tmp.length;k++){
			array[start+k]=tmp[k];
		}
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 10, 5, 6, 7, 0};
		InversePairs solution = new InversePairs();
		System.out.println(solution.InversePairs(input));

	}
}
