package algorithm.sort;

/**
 * @author wanhaoran
 * @date 2018年3月10日 上午11:43:16
 */
public class QuickSort {

	public static void QuickSort(int[] array, int left, int right) {
		if (left>=right){
			return;
		}
		int j = partition(array,left,right);
		QuickSort(array,left,j-1);
		QuickSort(array,j+1,right);
	}

	static private int partition(int[] array, int left, int right){
		int i =left;
		int j = right+1;

		int v = array[left];

		while (true){
			while (array[++i]<v && i!=right);
			while (array[--j]>v && j!=left);
			if (i>j){
				break;
			}
			int p = array[i];
			array[i] =array[j];
			array[j]=p;
		}
		int p = array[left];
		array[left] =array[j];
		array[j]=p;
		return j;
	}


}
