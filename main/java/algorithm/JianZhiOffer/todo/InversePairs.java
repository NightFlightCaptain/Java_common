package algorithm.JianZhiOffer.todo;

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
	private int count = 0;

	public int InversePairs(int[] array) {
		merge(array, 0, array.length - 1);
		return count%1000000007;
	}

	private void merge(int[] arrsy, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = (start + end) >> 1;
		merge(arrsy, start, mid);
		merge(arrsy, mid + 1, end);
		merge2_array(arrsy, start, mid, end);
	}

	private void merge2_array(int[] array, int start, int mid, int end) {
		int[] tmp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		while (j <= end && i <= mid) {
			if (array[i] > array[j]) {
				tmp[k++] = array[j++];
				count += mid - i + 1;
				count%=1000000007;
			} else {
				tmp[k++] = array[i++];
			}
		}

		while (i <= mid) {
//			count += end - mid;
			tmp[k++] = array[i++];
		}
		while (j <= end) {
			tmp[k++]=array[j++];
		}
		for (int m = 0; m <= end - start; m++) {
			array[m + start] = tmp[m];
		}

	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 10, 5, 6, 7, 0};
		InversePairs solution = new InversePairs();
		System.out.println(solution.InversePairs(input));

	}
}
