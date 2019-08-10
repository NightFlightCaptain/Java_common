package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/10 9:03
 * <p>
 * 不重复打印排序数组中相加和为给定值的所有三元组
 * <p>
 * 题目描述
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序三元组
 * 例如, arr = [-8, -4, -3, 0, 1, 2, 4, 5, 8, 9], k = 10，打印结果为：
 * -4 5 9
 * -3 4 9
 * -3 5 8
 * 0 1 9
 * 0 2 8
 * 1 4 5
 * [要求]
 * 时间复杂度为O(n^2)
 * )，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行有两个整数n, k
 * 接下来一行有n个整数表示数组内的元素
 * 输出描述:
 * 输出若干行，每行三个整数表示答案
 * 按三元组从小到大的顺序输出(三元组大小比较方式为每个依次比较三元组内每个数)
 * 示例1
 * 输入
 * <p>
 * 10 10
 * -8 -4 -3 0 1 2 4 5 8 9
 * 输出
 * <p>
 * -4 5 9
 * -3 4 9
 * -3 5 8
 * 0 1 9
 * 0 2 8
 * 1 4 5
 */
public class CodeInterviewGuide4 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < n-2; i++) {
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            int target = k - a[i];
            while (left < right) {
                if (a[left] + a[right] == target) {
                    if (left == 1||a[left]!=a[left-1]) {
                        System.out.println(a[i] + " " + a[left] + " " + a[right]);
                    }
                    left++;
                    right--;
                    
                } else if (a[left] + a[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
}
