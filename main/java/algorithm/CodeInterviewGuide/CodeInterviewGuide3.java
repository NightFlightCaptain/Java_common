package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/9 22:38
 *
 * 不重复打印排序数组中相加和为给定值的所有二元组
 *
 * <p>
 * 题目描述
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组
 * 例如, arr = [-8, -4, -3, 0, 1, 2, 4, 5, 8, 9], k = 10，打印结果为：
 * 1, 9
 * 2, 8
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行有两个整数n, k
 * 接下来一行有n个整数表示数组内的元素
 * <p>
 * 输出描述:
 * 输出若干行，每行两个整数表示答案
 * 按二元组从小到大的顺序输出(二元组大小比较方式为每个依次比较二元组内每个数)
 * <p>
 * 示例1
 * 输入
 * 10 10
 * -8 -4 -3 0 1 2 4 5 8 9
 * 输出
 * 1 9
 * 2 8
 */
public class CodeInterviewGuide3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        //双向指针，当数组有排序的时候，时间复杂度要求为O(n)的时候考虑双向指针
        int left = 0, right = n - 1;
        while (left < right) {
            if (a[left] + a[right] == k) {
                /*
                System.out.println(a[left] + " " + a[right]);
                left++;
                right--;
                while (left<n&& a[left] == a[left - 1]) {
                    left++;
                }
                while (right>=0&&a[right] == a[right+1]) {
                    right--;
                }
                */
                if (left == 1||a[left]!=a[left-1]) {
                    System.out.println(a[left] + " " + a[right]);
                }
                left++;
                right--;
                //不要在代码中再加循环

            } else if (a[left] + a[right] < k) {
                left++;
            } else {
                right--;
            }
        }
    }
}
