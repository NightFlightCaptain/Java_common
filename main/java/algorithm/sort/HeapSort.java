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
        nums = new int[]{3, 5, 7, 6, 1};
        heapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    升序大顶堆，降序小顶堆
     */

    /**
     * 找到父节点的值，判断父节点和左右子节点的大小，然后将子节点的值填充到父节点，
     * 然后再将新节点作为父节点进行同样的判断，直到叶子节点或当前节点的值比最开始的父节点小（大根堆）
     *
     * @param nums
     * @param parent
     * @param size
     */
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

    /**
     * 从最后一个非叶子节点开始，进行排序
     * @param nums
     */
    private void buildHeap(int[] nums) {
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjustDown(nums, i, size);
        }
    }

    /**
     * 建立大顶堆，每次将堆顶的值依次移动都最后面，直到全部节点都移动完毕
     * @param nums
     */
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

