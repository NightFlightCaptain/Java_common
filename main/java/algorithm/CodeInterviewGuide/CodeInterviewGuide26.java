package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【子数组的最大累加和问题】
 * <p>
 * 题目描述
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行一个整数N。表示数组长度
 * 接下来一行N个整数表示数组内的元素
 * 输出描述:
 * 输出一个整数表示答案
 *
 * 示例1
 * 输入
 * 7
 * 1 -2 3 5 -2 6 -1
 * 输出
 * 12
 * 备注:
 * 1<=N<=10^5
 * −100<=arr_i<=100
 *
 * @author: 小栗旬
 * @Date: 2019/9/6 20:44
 */
public class CodeInterviewGuide26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int max =0;
        int cur =0;
        for (int i=0;i<nums.length;i++){
            if (cur+nums[i] <0){
                cur=0;
            }else {
                cur+=nums[i];
                max = Math.max(max,cur);
            }
        }
        System.out.println(max);
    }
}
