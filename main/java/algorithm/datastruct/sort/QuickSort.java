package algorithm.datastruct.sort;

import java.util.Arrays;

/**
 * @author wanhaoran
 * @date 2018年3月10日 上午11:43:16
 */
public class QuickSort {

    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int j = partition(array, left, right);
        QuickSort(array, left, j - 1);
        QuickSort(array, j + 1, right);
    }

    /**
     * 奇数在前 偶数在后
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    private static int partition2(int[] array, int left, int right) {
        int v = array[left];
        while (left < right) {
            while (left < right && (array[right] & 1) == 0) {
                right--;
            }
            array[left] = array[right];
            while (left < right && (array[left] & 1) == 1) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = v;
        return left;
    }


    static private int partition(int[] array, int left, int right) {
        int v = array[left];

        while (left < right) {
            while (left < right && array[right] > v) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < v) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = v;
        return left;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tem = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tem;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{59, 20, 83, 13, 28, 14, 23, 17, 21};
        nums = new int[]{83, 59, 28, 23, 21, 20, 17, 14, 13};
        QuickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

}
