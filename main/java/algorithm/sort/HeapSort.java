package algorithm.sort;

import java.util.Arrays;

/**
 * @author wanhaoran
 * @date 2018年5月23日 上午9:11:48
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 7, 2, 1};
        HeapSort heapSort = new HeapSort();
//        heapSort.sort(nums);
//        System.out.println(Arrays.toString(nums));
        nums = new int[]{3,5,7,6,1};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }


    private void adjustDown(int[] nums, int parent, int size) {
        int temp = nums[parent];
        for (int i = parent * 2 + 1; i < size; i = i * 2 + 1) {
            if (i + 1 < size && nums[i + 1] > nums[i]) {
                i++;
            }
            if (nums[i] < temp) {
                break;
            } else {
                nums[parent] = nums[i];
                parent = i;
            }
        }
        nums[parent] = temp;
    }

    private void buildHeap(int[] nums) {
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjustDown(nums, i, size);
        }
    }

    public void sort(int[] nums) {
        buildHeap(nums);
        int size = nums.length;
        for (int i = size - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustDown(nums, 0, i);
        }
    }

}

