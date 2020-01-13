package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【岛屿数量】
 * <p>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/11 19:49
 */
public class LeetCode200 {

    public int numIslands(char[][] grid) {
        return bfsMethod(grid);
    }

    /*dfs 深度优先遍历*/

    int[][] direction = new int[][]{
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    private int defMethod(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    dfs(grid, isVisited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] isVisited, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        isVisited[i][j] = true;
        for (int dir = 0; dir < 4; dir++) {
            int newI = i + direction[dir][0];
            int newJ = j + direction[dir][1];
            if (newI >= 0 && newI < row && newJ >= 0 && newJ < col
                    && !isVisited[newI][newJ] && grid[newI][newJ] == '1') {
                dfs(grid, isVisited, newI, newJ);
            }
        }
    }

    /*  bfs广度优先遍历,bfs需要使用到队列 */

    private int bfsMethod(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    queue.add(i*col+j);
                    isVisited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int num = queue.poll();
                        int m = num/col;
                        int n = num%col;
                        for (int dir = 0; dir < 4; dir++) {
                            int newI = m + direction[dir][0];
                            int newJ = n + direction[dir][1];
                            if (newI >= 0 && newI < row && newJ >= 0 && newJ < col
                                    && !isVisited[newI][newJ] && grid[newI][newJ] == '1') {
                                queue.add(newI*col+newJ);
                                isVisited[newI][newJ] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode200 solution = new LeetCode200();
        char[][] grid = {
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };
        System.out.println(solution.numIslands(grid) == 1);
        grid = new char[][]{
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '0', '0', '1', '1' }
        };
        System.out.println(solution.numIslands(grid) == 3);
        grid = new char[][]{
                {'1', '1', '0', '0', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '1', '0', '0' },
                {'0', '1', '0', '1', '1' }
        };
        System.out.println(solution.numIslands(grid) == 4);
        grid = new char[][]{
                {'1', '1', '0', '0', '0' }
        };
        System.out.println(solution.numIslands(grid) == 1);
        grid = new char[][]{
                {'1', '0', '1', '0', '1' }
        };
        System.out.println(solution.numIslands(grid) == 3);
        grid = new char[][]{

        };
        System.out.println(solution.numIslands(grid) == 0);
        grid = new char[][]{
                {'1', '1', '1' },
                {'1', '0', '1' },
                {'1', '1', '1' }
        };
        System.out.println(solution.numIslands(grid) == 1);
        grid = new char[][]{
                {'1', '1', '1' },
                {'0', '1', '0' },
                {'1', '1', '1' }
        };
        System.out.println(solution.numIslands(grid) == 1);
    }
}
