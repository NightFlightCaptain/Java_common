package algorithm.realExam.PDD2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【两两配对差值最小】
 * <p>
 * 给定一个长度为偶数的数组arr，将该数组中的数字两两配对并求和，在这些和中选出最大和最小值，请问该如何两两配对，才能让最大值和最小值的差值最小？
 * <p>
 * 输入描述:
 * 一共2行输入。
 * 第一行为一个整数n，2<=n<=10000, 第二行为n个数，组成目标数组，每个数大于等于2，小于等于100。
 * <p>
 * 输出描述:
 * 输出最小的差值。
 * <p>
 * 输入例子1:
 * 4
 * 2 6 4 3
 * <p>
 * 输出例子1:
 * 1
 * <p>
 * 输入例子2:
 * 6
 * 11 4 3 5 7 1
 * <p>
 * 输出例子2:
 * 3
 *
 * @author: 小栗旬
 * @Date: 2019/11/25 21:04
 */
public class PDD2019C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n / 2; i++) {
            int num = nums[i] + nums[n - 1 - i];
            if (num > max){
                max = num;
            }
            if (num < min){
                min = num;
            }
        }
        System.out.println(max - min);
    }
}
