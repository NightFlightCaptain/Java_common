package algorithm.datastruct.queue;

import java.util.Arrays;

/**
 * @author: 小栗旬
 * @Date: 2020/3/23 20:40
 */
public class SelfPriorityQueue {
    private int[] nums;
    private int size;

    public SelfPriorityQueue(int size) {
        nums = new int[size];
        this.size = 0;
    }

    private void adjustDown(int parent, int size) {
        int temp = nums[parent];
        for (int i = parent * 2 + 1; i < size; i = i * 2 + 1) {
            if (i + 1 < size && nums[i] < nums[i + 1]) {
                i++;
            }
            if (temp < nums[i]) {
                nums[parent] = nums[i];
            } else {
                break;
            }
            parent = i;
        }
        nums[parent] = temp;
    }

    private void buildHeap() {
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjustDown(i, size);
        }
    }

    private void add(int num) {
        if (nums.length == size) {
            return;
        }
        nums[size++] = num;
        if (size == 1) {
            return;
        }
        adjustDown(size / 2 - 1, size);

    }

    private int getFirst() {
        int temp = nums[0];
        nums[0] = nums[size-1];
        nums[size-1] = 0;
        size--;
        adjustDown(0,size);
        return temp;
    }

    public static void main(String[] args) {
        SelfPriorityQueue main = new SelfPriorityQueue(5);
        System.out.println(Arrays.toString(main.nums));
        main.add(3);
        main.add(6);
        main.add(9);
        main.add(2);
        main.add(5);
        System.out.println(Arrays.toString(main.nums));
        System.out.println(main.getFirst());
        System.out.println(Arrays.toString(main.nums));
        System.out.println(main.getFirst());
        System.out.println(Arrays.toString(main.nums));
        System.out.println(main.getFirst());
        System.out.println(Arrays.toString(main.nums));
        main.add(7);
        System.out.println(Arrays.toString(main.nums));

    }
}
