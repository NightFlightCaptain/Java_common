package algorithm.sort;

/**
 *
 * @author wanhaoran
 * @date 2018年3月8日 下午8:23:03
 *
 */
public class BubbleSort {

	public static void BubbleSort(int[] array) {
		int temp;
		for (int i = array.length - 1; i > 0; i--) {
			boolean flag = true;
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
	}

}
