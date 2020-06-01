package algorithm.datastruct.sort;

/**
 *
 * @author wanhaoran
 * @date 2018年3月8日 下午8:29:17
 *
 */
public class Main {

	public static void main(String[] args) {
		int[] array = { 59, 20, 17, 13, 28, 14, 23, 83, 21 };
		int[] newArray = new int[array.length];
		// BubbleSort.BubbleSort(array);
		// SelctionSort.SelctionSort(array);
		// InsertionSort.InsertionSore(array);
		// InsertionSort.insert_sort(array, array.length);
//		newArray = ShellSort.ShellSort(array, 7);
		QuickSort.QuickSort(array,0,array.length-1);
		for (int i : array) {
			System.out.println(i);
		}
	}

	static void exch(int[] a, int i, int j) {
		try {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("index出界");
		}
	}
}
