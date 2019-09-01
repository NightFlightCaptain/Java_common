package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【自然数数组的排序】
 * 题目描述
 * 给定一个长度为N的整形数组arr，其中有N个互不相等的自然数1-N。请实现arr的排序，
 * 但是不要把下标0∼N−1位置上的数通过直接赋值的方式替换成1∼N
 * <p>
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
 * <p>
 * 输入描述:
 * 第一行有一个整数N。表示数组长度
 * 接下来一行有N个互不相等的自然数1-N。
 * <p>
 * 输出描述:
 * 输出N个整数表示排序后的结果
 * <p>
 * 示例1
 * 输入
 * 5
 * 2 1 4 5 3
 * 输出
 * 1 2 3 4 5
 * 备注:
 * 1<=N<=10^5
 *
 * @author: 小栗旬
 * @Date: 2019/9/1 15:43
 */
public class CodeInterviewGuide23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int temp;
        int next;
        for (int i = 0; i < n; i++) {
            temp = nums[i];
            //每个nums都会被执行一遍，下面这个while循环在整个程序中总共执行了n次，和外面的for循环是相对对立的，每次for进来不会刷新while
            while (nums[temp-1]!=temp){
                next = nums[temp-1];
                nums[temp-1] = temp;
                temp = next;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
