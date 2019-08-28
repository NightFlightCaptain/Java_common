package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/28 12:00
 * <p>
 * 题目描述
 * 给定一个整型矩阵 map，其中的值只有 0 和 1 两种，求其中全是 1 的所有矩形区域中，最大的矩形区域里 1 的数量。
 * <p>
 * 输入描述:
 * 第一行输入两个整数 n 和 m，代表 n*m 的矩阵
 * 接下来输入一个 n*m 的矩阵
 * <p>
 * 输出描述:
 * 输出其中全是 1 的所有矩形区域中，最大的矩形区域里 1 的数量。
 * <p>
 * 示例1
 * 输入
 * 1 4
 * 1 1 1 0
 * <p>
 * 输出
 * 3
 * 说明
 * 最大的矩形区域有3个1，所以返回3
 */
public class CodeInterviewGuide16 {
    /* 解析写在LeetCode85中 */
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


        int[] leftMinIndex = new int[m];
        int[] rightMinIndex = new int[m];

        Arrays.fill(leftMinIndex, -1);
        Arrays.fill(rightMinIndex, m);
        int area = 0;
        int[] heights = new int[m];

        for (int i = 0; i < n; i++) {
            int[] curNums = nums[i];
            //求当前高度
            for (int j = 0; j < m; j++) {
                if (curNums[j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            //求当前柱左边的比当前柱矮的最远
            int curIndexForZero = -1;
            for (int j = 0; j < m; j++) {
                if (curNums[j] == 0) {
                    leftMinIndex[j] = -1;
                    curIndexForZero = j;
                } else {
                    leftMinIndex[j] = Math.max(curIndexForZero, leftMinIndex[j]);
                }
            }

            //求当前柱右边最小值
            curIndexForZero = -1;
            for (int j = m - 1; j >= 0; j--) {
                if (curNums[j] == 0) {
                    rightMinIndex[j] = m;
                    curIndexForZero = j;
                } else {
                    rightMinIndex[j] = Math.min(curIndexForZero, rightMinIndex[j]);
                }
            }

            for (int j = 0; j < m; j++) {
                area = Math.max(area, heights[j] * (rightMinIndex[j] - leftMinIndex[j] - 1));
            }
        }
        System.out.println(area);
    }
}
