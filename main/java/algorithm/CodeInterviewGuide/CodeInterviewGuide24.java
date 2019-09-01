package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【奇数下标都是奇数或者偶数下标都是偶数】
 * <p>
 * 题目描述
 * 给定一个长度不小于2的数组arr，实现一个函数调整arr，要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
 * 注意：1、数组下标从0开始！
 * 2、本题有special judge，你可以输出任意一组合法解！同时可以证明解一定存在
 * [要求]
 * 时间复杂度为O(n)，额外空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行一个整数N。表示数组长度
 * 接下来一行N个整数表示数组内的数
 * 输出描述:
 * 输出N个整数。表示调整后的数组
 * 示例1
 * 输入
 * 5
 * 1 2 3 4 5
 * 输出
 * 2 1 4 3 5
 * 说明
 * 样例中的输出保证了奇数下标都是奇数
 * 备注:
 * 2<=N<=10^5
 * 0<=arr_i<=10^9
 *
 * @author: 小栗旬
 * @Date: 2019/9/1 16:17
 */
public class CodeInterviewGuide24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int evenIndex = 0;
        int oddIndex = 1;
//        while (evenIndex < n && oddIndex < n) {
//            //偶数下标不是偶数
//            if ((nums[evenIndex] & 1) == 1) {
//                //找到第一个奇数下标不是奇数的
//                while (oddIndex < n && (nums[oddIndex] & 1) == 1) {
//                    oddIndex += 2;
//                }
//                if (oddIndex < n) {
//                    swap(nums, oddIndex, evenIndex);
//                }
//            }
//            evenIndex += 2;
//            if ((nums[oddIndex] & 1) == 0) {
//                while (evenIndex < n && (nums[evenIndex] & 1) == 0) {
//                    evenIndex += 2;
//                }
//                if (evenIndex<n) {
//                    swap(nums, oddIndex, evenIndex);
//                }
//            }
//            oddIndex += 2;
//        }

        while (evenIndex < n && oddIndex < n) {
            if ((nums[n - 1] & 1) == 1) {
                swap(nums, oddIndex, n - 1);
                oddIndex += 2;
            } else {
                swap(nums, evenIndex, n - 1);
                evenIndex += 2;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int re : nums) {
            stringBuilder.append(" ").append(re);
        }
        System.out.println(stringBuilder.substring(1));
    }

    //5 12345
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
