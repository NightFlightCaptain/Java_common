package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【数组和矩阵问题】【边界都是1的最大正方形大小】
 * <p>
 * 题目描述
 * 给定一个N×N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度、
 * 例如
 * 0 1 1 1 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 1 1 1
 * 0 1 0 1 1
 * 其中，边框全是1的最大正方形的大小为4×4，所以返回4
 * [要求]
 * 时间复杂度为O(n^3)，空间复杂度为O(n^2)
 * 输入描述:
 * 第一行一个整数N。表示矩阵的长宽。
 * 接下来N行，每行N个整数表示矩阵内的元素
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 5
 * 0 1 1 1 1
 * 0 1 0 0 1
 * 0 1 0 0 1
 * 0 1 1 1 1
 * 0 1 0 1 1
 * 输出
 * 4
 * 备注:
 * 1<=N<=200
 * matrix_i,j=0/1
 *
 * @author: 小栗旬
 * @Date: 2019/9/21 14:52
 */
public class CodeInterviewGuide41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        int[][] rowDp = new int[n][n];
        int[][] colDp = new int[n][n];
        /*
          5
          1 1 1 1 1
          0 0 1 0 1
          1 0 1 1 1
          1 0 1 0 1
          1 1 1 1 1
        
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] == 1) {
                    if (j == 0) {
                        rowDp[i][j] = 1;
                    } else {
                        rowDp[i][j] = rowDp[i][j - 1] + 1;
                    }
                } else {
                    rowDp[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (nums[i][j] == 1) {
                    if (i == 0) {
                        colDp[i][j] = 1;
                    } else {
                        colDp[i][j] = colDp[i - 1][j] + 1;
                    }
                } else {
                    colDp[i][j] = 0;
                }
            }
        }

        int maxEdgeLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxLength = Math.min(rowDp[i][j], colDp[i][j]);
                int edgeLength = 0;
                for (int length = maxLength; length > 0; length--) {
                    if (rowDp[i-length+1][j] >= length && colDp[i][j - length + 1] >= length) {
                        edgeLength = length;
                        break;
                    }
                }
                maxEdgeLength = Math.max(maxEdgeLength,edgeLength);
            }
        }

        System.out.println(maxEdgeLength);
    }
}
