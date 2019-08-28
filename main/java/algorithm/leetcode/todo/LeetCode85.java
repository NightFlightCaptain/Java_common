package algorithm.leetcode.todo;

import java.util.Arrays;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 *
 * @author: 小栗旬
 * @Date: 2019/8/27 8:21
 */
public class LeetCode85 {
    /**
     * 时间复杂度O(m*n*n) 空间复杂度O(n)
     * 判断每一个点向左延申最多能延申多少。然后从上往下以每一个点为右上角作为矩形求最大矩形
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height <= 0) {
            return 0;
        }
        int width = matrix[0].length;
        int[] maxWidth = new int[height];
        int area = 0;

        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        maxWidth[i] = 1;
                    } else {
                        maxWidth[i] = maxWidth[i] + 1;
                    }
                } else {
                    maxWidth[i] = 0;
                }
            }

            for (int k = 0; k < height; k++) {
                int maxW = Integer.MAX_VALUE;
                int maxH = 0;
                for (int i = k; i < height; i++) {
                    if (maxWidth[i] == 0) {
                        maxH = 0;
                    } else {
                        maxH++;
                        maxW = Math.min(maxW, maxWidth[i]);
                        area = Math.max(area, maxW * maxH);
                    }
                }
            }
        }
        return area;
    }

    /**
     * 动态规划
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        int height = matrix.length;
        if (height <= 0) {
            return 0;
        }
        int width = matrix[0].length;
        int[] leftMaxIndex = new int[width];
        int[] rightMaxIndex = new int[width];
        Arrays.fill(leftMaxIndex, -1);
        Arrays.fill(rightMaxIndex, width);

        int[] heights = new int[width];
        int area = 0;
        for (int i = 0; i < height; i++) {
            char[] temp = matrix[i];
            //求高度
            for (int j = 0; j < width; j++) {
                if (temp[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            //求左边比当前柱矮的最近的柱的坐标
            //每一次更新都是在原有基础上的更新，只有出现了'0'才会导致leftMaxIndex的变化，不然leftMaxIndex都是原来的值
            //boundary是指最新出现0的坐标
            int boundary = -1;
            for (int j = 0; j < width; j++) {
                if (temp[j] == '1') {
                    leftMaxIndex[j] = Math.max(leftMaxIndex[j], boundary);
                } else {
                    //如果这个地方为'0'，那么以该点为柱中心的矩形就不存在了
                    //这里置为-1是因为怕影响下一行的判断，置为-1下一行的比较就会取出现0的地方
                    leftMaxIndex[j] = -1;
                    boundary = j;
                }
            }

            //求右边比当前柱矮的最近的柱的坐标
            boundary = width;
            for (int j =width-1;j>=0;j--){
                if (temp[j] == '1') {
                    rightMaxIndex[j] = Math.min(rightMaxIndex[j], boundary);
                } else {
                    rightMaxIndex[j] = width;
                    boundary = j;
                }
            }

            for (int j = 0; j < width; j++) {
                int w = rightMaxIndex[j] - leftMaxIndex[j] - 1;
                int h = heights[j];
                area = Math.max(area, w * h);
            }

        }
        return area;

    }


    public static void main(String[] args) {
        LeetCode85 solution = new LeetCode85();
        char[][] a = {
//                {'1', '0', '1', '0', '0'},
//                {'1', '0', '1', '1', '1'},
//                {'1', '1', '1', '1', '1'},
//                {'1', '0', '0', '1', '0'}
                {'0','0','0','0'},
                {'1','1','0','0'},
        };
        System.out.println(solution.maximalRectangle2(a));
    }
}
