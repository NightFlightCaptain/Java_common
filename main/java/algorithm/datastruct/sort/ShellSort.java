package algorithm.datastruct.sort;

/**
 *
 * @author wanhaoran
 * @date 2018年3月10日 上午9:36:58
 *
 */
public class ShellSort {

	public static int[] ShellSort(int[] array, int length) {
		int incre = length;
		int len = array.length;
		while (incre >= 1) {//增量逐渐减少直至1
			for (int i = 0; i < incre; i++) {//按照当前增量分组
				for (int j = i + incre; j < len; j+=incre) {
					int temp;
					for (int k = i; k < j; k += incre) {
						if (array[j] < array[k]) {
							temp = array[k];
							array[k] = array[j];
							array[j] = temp;
						}
					}
				}
				
			}
			incre /= 2;
		}
		return array;
	}

}
