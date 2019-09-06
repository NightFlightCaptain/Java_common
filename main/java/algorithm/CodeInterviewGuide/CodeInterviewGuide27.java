package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【前缀和】【子矩阵的最大累加和问题】
 * <p>
 * 题目描述
 * 给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和
 * 例如，矩阵matrix为：
 * -90 48 78
 * 64 -40 64
 * -81 - 7 66
 * 其中，最大的累加和的子矩阵为：
 * 48 78
 * -40 64
 * -7 66
 * 所以返回累加和209。
 * <p>
 * 例如，matrix为：
 * -1 -1 -1
 * -1 2 2
 * -1 -1 -1
 * 其中，最大累加和的子矩阵为：
 * 2 2
 * 所以返回4
 * <p>
 * [要求]
 * 时间复杂度为O(n^2m)，空间复杂度为O(nm)
 * <p>
 * 输入描述:
 * 第一行有两个整数N，M。分别表示矩阵的行数/列数
 * 接下来N行，每行M个整数表示矩阵内的数
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 3 3
 * -90 48 78
 * 64 -40 64
 * -81 -7 66
 * 输出
 * 209
 * 示例2
 * 输入
 * 3 3
 * -1 -1 -1
 * -1 2 2
 * -1 -1 -1
 * 输出
 * 4
 * <p>
 * 备注:
 * 1<=N,M<=200
 * −100<=arr_i,arr_j<=100
 *
 * @author: 小栗旬
 * @Date: 2019/9/6 20:52
 */
public class CodeInterviewGuide27 {
    //实际解法不需要O(nm)的空间复杂度，只需要O(m+n)甚至更小
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[m];
            for (int j = i ; j < n; j++) {
                int[] arr2 = nums[j];
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    arr[k] += arr2[k];
                }
                for (int k = 0; k < m; k++) {
                    if (cur + arr[k] < 0) {
                        cur = 0;
                    } else {
                        cur += arr[k];
                        max = Math.max(max, cur);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
