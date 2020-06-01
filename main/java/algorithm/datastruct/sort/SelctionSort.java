package algorithm.datastruct.sort;

/**
 *
 * @author wanhaoran
 * @date 2018年3月8日 下午8:36:30
 *
 */
public class SelctionSort {

	public static void SelctionSort(int[] array) {
		
		
		for (int j = 0; j < array.length-1; j++) {
			
			int maxIndex = j;
			for (int i = j+1; i < array.length; i++) {
				if (array[i] > array[maxIndex]) {	
					maxIndex= i;
				}
			}
			if (maxIndex !=j) {
				
				int temp = array[maxIndex];
				array[maxIndex] = array[j];
				array[j] = temp;		
			}
		}
	}
}
