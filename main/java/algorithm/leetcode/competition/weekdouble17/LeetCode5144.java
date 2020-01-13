package algorithm.leetcode.competition.weekdouble17;

import java.util.Arrays;

/**
 * 【1314 矩阵区域和】
 * <p>
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 * <p>
 * i - K <= r <= i + K, j - K <= c <= j + K
 * (r, c) 在矩阵内。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n, K <= 100
 * 1 <= mat[i][j] <= 100
 *
 * @author: 小栗旬
 * @Date: 2020/1/11 22:47
 */
public class LeetCode5144 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = 0;
                for (int p = Math.max(0, i - K); p < Math.min(m, i + K + 1); p++) {
                    for (int q = Math.max(0, j - K); q < Math.min(n, j + K + 1); q++) {
                        cur+=mat[p][q];
                    }
                }
                answer[i][j] = cur;
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        LeetCode5144 solution = new LeetCode5144();
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(solution.matrixBlockSum(mat, 1)));
    }
}
