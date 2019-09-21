package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【双指针】【数组中未出现的最小正整数】
 * <p>
 * 题目描述
 * 给定一个无序数组arr，找到数组中未出现的最小正整数
 * 例如arr = [-1, 2, 3, 4]。返回1
 * arr = [1, 2, 3, 4]。返回5
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行为一个整数N。表示数组长度。
 * 接下来一行N个整数表示数组内的数
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 4
 * -1 2 3 4
 * 输出
 * 1
 * 示例2
 * 输入
 * 4
 * 1 2 3 4
 * 输出
 * 5
 * 备注:
 * 1<=N<=10^6
 * <p>
 * −10^9<=arr_i<=10^9
 *
 * @author: 小栗旬
 * @Date: 2019/9/20 15:07
 */
public class CodeInterviewGuide39 {
    /**
     * 如果n=12，那么标准情况下数组上的位置就应该是从1-12
     * 设置一个变量left，left表示的是到left为止都是标准情况，right表示的是右边界。
     * 如果新出现的值是已经在标准情况里面的，或者这个值比right大，也就是超过了边界，那么这个值就是不用的，将其放在数组的最后边，然后边界right--
     * 如果这个值在范围里面（left到right之间）那么就将它放在它应该在的位置
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        /*
        14
2 109 1 4 3 9 9 6 5 2 4 1 9 4
         */
        int left = 0, right = n - 1;
        while (left <= right) {
            if (nums[left] == left + 1) {
                left++;
            } else if (nums[left] < left + 1 || nums[left] > right) {
                swap(nums, left, right);
                right--;
            } else if (nums[left] > left + 1) {
                if (nums[nums[left] - 1] == nums[left]) {
                    swap(nums, left, right);
                    right--;
                } else {
                    swap(nums, left, nums[left] - 1);
                }
            }
        }
        System.out.println(left + 1);

    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
