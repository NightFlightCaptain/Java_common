package algorithm.leetcode;

import java.util.Arrays;

/**
 * 【旋转图像】
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/4 20:24
 */
public class LeetCode48 {
    /**
     * 每个位置其实就算四个位置的轮换。
     第一层循环：从左上角开始往中心走
     第二层循环：走完这一行，每个点其实都只和另外3个点相关联，找出这四个点之间的关系。
     变化规律如下：(n-1-y,x)->(x,y)->(y,n-i-x)

     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            for (int j = i; j < length - 1-i; j++) {
                int lastValue = matrix[length - 1 - j][i];
                int count = 0;
                int x = i;
                int y = j;
                while (count++ < 4) {
                    int temp = matrix[x][y];
                    matrix[x][y] = lastValue;
                    lastValue = temp;
                    temp = x;
                    x = y;
                    y = length - 1 - temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode48 solution = new LeetCode48();
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{};
    }
}
