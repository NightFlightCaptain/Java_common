package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【桶排】【数组的partition调整补充问题】
 * <p>
 * 题目描述
 * 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行一个整数N。表示数组长度
 * 接下来一行N个整数表示数组内的数
 * 输出描述:
 * 输出N个整数，表示排序后的结果
 * 示例1
 * 输入
 * 5
 * 2 0 1 2 0
 * 输出
 * 0 0 1 2 2
 * 备注:
 * 1⩽N⩽10^5
 * <p>
 * 保证arr_i=0/1/2
 *
 * @author: 小栗旬
 * @Date: 2019/9/15 16:52
 */
public class CodeInterviewGuide37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int leftIndex = 0, rightIndex = n - 1;
        int i = 0;
        while (i <= rightIndex) {
            if (nums[i] == 0) {
                swap(nums, leftIndex, i);
                leftIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, rightIndex, i);
                rightIndex--;
            } else {
                i++;
            }
        }

//        for (int i=leftIndex;i<n;i++){
//            if (nums[i]==1){
//                swap(nums,leftIndex,i);
//                leftIndex++;
//            }
//        }

        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(nums).forEachOrdered(o -> stringBuilder.append(" ").append(o));
        System.out.println(stringBuilder.substring(1));
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
