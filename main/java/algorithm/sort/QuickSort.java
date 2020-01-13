package algorithm.sort;

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

    static private int partition(int[] array, int left, int right) {
        int v = array[left];

        while (left < right) {
            while (left < right && array[right] > v) {
                right--;
            }
            array[left] = array[right];
            while (left<right && array[left] <v){
                left++;
            }
            array[right] =array[left];
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
        int[] nums = new int[]{-1, 2, 0};
        QuickSort(nums, 0, 2);
        System.out.println(Arrays.toString(nums));
    }

}
