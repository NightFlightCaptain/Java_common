package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【动态规划】	【数组中子数组的最大累乘积】
 * <p>
 * 题目描述
 * 给定一个double类型的数组arr，其中的元素可正、可负、可0，返回子数组累乘的最大乘积。例如，arr=[-2.5, 4, 0, 3, 0.5, 8, -1]，子数组[3, 0.5, 8]累乘可以获得最大的乘积12，所以返回12
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行一个整数N。表示数组长度。
 * 接下来一行N个浮点数表示数组内的数
 * 输出描述:
 * 输出一个浮点数表示答案，保留到小数点后两位
 * 示例1
 * 输入
 * 7
 * -2.5 4 0 3 0.5 8 -1
 * 输出
 * 12.00
 * 备注:
 * 1<=N<=10^5
 * −100<arr_i<=100
 * −10^22<=保证最后的答案<=10^22
 *
 * @author: 小栗旬
 * @Date: 2019/9/14 15:19
 */
public class CodeInterviewGuide32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextDouble();
        }

        double res = Double.MIN_VALUE;
        double max = 1;
        double min = 1;
        for (int i = 0; i < n; i++) {
            double newNum1 = max * nums[i];
            double newNum2 = min * nums[i];
            res = Math.max(res, Math.max(newNum1,newNum2));
            min = Math.min(1, Math.min(newNum1,newNum2));
            max = Math.max(1, Math.max(newNum1,newNum2));
        }
        System.out.println(String.format("%.2f", res));
    }
}
