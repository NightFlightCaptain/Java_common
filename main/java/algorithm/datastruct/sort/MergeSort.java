package algorithm.datastruct.sort;

import java.util.Arrays;

/**
 * @author: 小栗旬
 * @Date: 2019/8/30 19:38
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] a=  {6,5,2,3,4,1};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }

    private void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        merge(nums, 0, nums.length-1);
    }

    private void merge(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end-start)>>1);
        merge(nums,start,mid);
        merge(nums,mid+1,end);
        merge(nums,start,mid,end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] h = new int[end - start + 1];
        int hi = 0;
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            h[hi++] = nums[i]<=nums[j]?nums[i++]:nums[j++];
        }
        while (i<=mid){
            h[hi++]=nums[i++];
        }
        while (j<=end){
            h[hi++]=nums[j++];
        }
        for (int k =start;k<=end;k++){
            nums[k]=h[k-start];
        }
    }
}
