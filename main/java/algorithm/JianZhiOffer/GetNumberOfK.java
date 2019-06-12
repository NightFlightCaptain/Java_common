package algorithm.JianZhiOffer;

/**
 * Author: 小栗旬
 * Date: 2019/3/2 19:31
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
	/*
	解法一：
	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		int length = array.length;
		int mid = getIndexOfK(array, k, 0, length - 1);
		if (mid == -1) {
			return 0;
		}
		int index = mid;
		while (index < length && array[index++] == k) {
			count++;
		}
		index = mid - 1;
		while (index >= 0 && array[index--] == k) {
			count++;
		}
		return count;

	}

	private int getIndexOfK(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) >> 1;
		if (array[mid] > k) {
			return getIndexOfK(array, k, start, mid - 1);
		} else if (array[mid] < k) {
			return getIndexOfK(array, k, mid + 1, end);
		} else {
			return mid;
		}
	}
	*/

	/*
	解法二：
	public int GetNumberOfK(int[] array, int k) {
	 int length = array.length;
		int start = getFirstIndexOfK(array, k, 0, length - 1);
		int end = getLastIndexOfK(array, k, 0, length - 1);
		if (start != -1 && end!=-1){
			return end-start+1;
		}
		return 0;
		}
	private int getFirstIndexOfK(int[] array, int k, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) >> 1;
		if (array[mid] > k) {
			return getIndexOfK(array, k, start, mid - 1);
		} else if (array[mid] < k) {
			return getIndexOfK(array, k, mid + 1, end);
		} else if (mid - 1 > 0 && array[mid - 1] == k) {
			return getIndexOfK(array, k, start, mid - 1);
		} else {
			return mid;
		}
	}

	private int getLastIndexOfK(int[] array, int k, int start, int end) {
		while (start <= end) {
			int mid = (start + end) >> 1;
			if (array[mid] > k) {
				end = mid - 1;
			} else if (array[mid] < k) {
				start = mid + 1;
			} else if (mid + 1 <= end && array[mid + 1] == k) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	*/

	public int GetNumberOfK(int[] array, int k) {
		int start = getIndexOfK(array, (k-0.5));
		int end = getIndexOfK(array, (k+0.5));
		if (k==7){
			System.out.println("start:" + start + " end:" + end);
		}
		return end-start;
	}

	private int getIndexOfK(int[] array, double k) {
		int start = 0, end = array.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) >> 1;
			if (array[mid] > k) {
				end = mid - 1;
			} else if (array[mid] < k) {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {

		int[] input = {4, 6, 6, 6, 7,8, 11, 14, 15};
		GetNumberOfK solution = new GetNumberOfK();
		for (int i = 0; i < 20; i++) {
			System.out.println(i + ":" + solution.GetNumberOfK(input, i));
		}
	}
}
