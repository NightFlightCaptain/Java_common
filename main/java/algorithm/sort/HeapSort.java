package algorithm.sort;

/**
 *
 * @author wanhaoran
 * @date 2018年5月23日 上午9:11:48
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		
	}
	
	private static void sink(Comparable[] t,int k,int N) {
		while(2*k<=N){
			int j = 2*k;

		}
	}
	
	public boolean less(Comparable[] heap,int i, int j) {
		return heap[i].compareTo(heap[j]) < 0;
	}
}

class Heap {
	private Comparable[] heap;
	private int N = 0;

	public Heap(int maxLength) {
		heap = new Comparable[maxLength];

	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int getSize() {
		return N;
	}

	public boolean less(int i, int j) {
		return heap[i].compareTo(heap[j]) < 0;
	}

	public void swap(int i, int j) {
		Comparable temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			swap(k / 2, k);
			k = k >> 1;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = k << 1;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			if (less(k, j)) {
				swap(k, j);
				k = j;
			} else {
				break;
			}
		}
	}
}
