package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 【最短路】 【求最短通路值】
 * <p>
 * <p>
 * 题目描述
 * 用一个整形矩阵matrix表示一个网格，1代表有路，0代表无路，每一个位置只要不越界，都有上下左右四个方向，求从最左上角到右下角的最短通路值
 * 例如，matrix为：
 * 1 0 1 1 1
 * 1 0 1 0 1
 * 1 1 1 0 1
 * 0 0 0 0 1
 * 通路只有一条，由12个1构成，所以返回12
 * [要求]
 * 时间复杂度为O(nm)，空间复杂度为O(nm)
 * <p>
 * 输入描述:
 * 第一行两个整数N，M表示矩形的长宽
 * 接下来N行，每行一个长度为M的字符串表示矩形
 * 输出描述:
 * 输出一个整数表示最小步数
 * 若从(1, 1)无法到达(n, m)请输出-1
 * 示例1
 * 输入
 * 4 5
 * 10111
 * 10101
 * 11101
 * 00001
 * 输出
 * 12
 * <p>
 * 示例2
 * 输入
 * 4 5
 * 11011
 * 11111
 * 11111
 * 00001
 * 输出
 * 8
 * <p>
 * 备注:
 * 1<=N,M<=1000
 * matrix_i,j=0/1，matrix_1,1=1,matrix_n,m=1
 *
 * @author: 小栗旬
 * @Date: 2019/9/20 10:23
 */
public class CodeInterviewGuide38 {

    /*
    4 5
11011
11111
11111
00001

 4 5
  10111
  10101
  11101
  00001

     */

    /**
     * 最短路径，从每一个点往四周遍历，广度优先遍历，这样在每个点都保证是最小值
     * 广度优先遍历，考虑队列
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        char[][] path = new char[n][m];
        Arrays.fill(path[0], '0');
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            for (int j = 0; j < line.toCharArray().length; j++) {
                path[i][j] = line.charAt(j);
            }
        }

        int[][] pathLength = new int[n][m];
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        pathLength[0][0] = 1;
        rowQueue.add(0);
        colQueue.add(0);
        int row = 0;
        int col = 0;
        while (!rowQueue.isEmpty()) {
            row = rowQueue.poll();
            col = colQueue.poll();
            if (row == n - 1 && col == m - 1) {
                break;
            }
            walk(path, pathLength, row, col, rowQueue, colQueue);
        }
        if (row < n-1 && col < m-1) {
            System.out.println(-1);
        }else {
            System.out.println(pathLength[n - 1][m - 1]);
        }
    }

    private static void walk(char[][] path, int[][] pathLength, int i, int j,
                             Queue<Integer> rowQueue, Queue<Integer> colQueue) {
        int rowLength = path.length;
        int colLength = path[i].length;
        if (i < rowLength - 1 && path[i + 1][j] == '1' && pathLength[i + 1][j] == 0) {
            pathLength[i + 1][j] = pathLength[i][j] + 1;
            rowQueue.add(i + 1);
            colQueue.add(j);
        }
        if (i > 0 && path[i - 1][j] == '1' && pathLength[i - 1][j] == 0) {
            pathLength[i - 1][j] = pathLength[i][j] + 1;
            rowQueue.add(i - 1);
            colQueue.add(j);
        }
        if (j < colLength - 1 && path[i][j + 1] == '1' && pathLength[i][j + 1] == 0) {
            pathLength[i][j + 1] = pathLength[i][j] + 1;
            rowQueue.add(i);
            colQueue.add(j + 1);
        }
        if (j > 0 && path[i][j - 1] == '1' && pathLength[i][j - 1] == 0) {
            pathLength[i][j - 1] = pathLength[i][j] + 1;
            rowQueue.add(i);
            colQueue.add(j - 1);
        }


    }
}
