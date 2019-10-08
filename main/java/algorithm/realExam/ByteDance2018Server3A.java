package algorithm.realExam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 【推箱子】
 * 有一个推箱子的游戏, 一开始的情况如下图:
 * <p>
 * 上图中, '.' 表示可到达的位置, '#' 表示不可到达的位置，其中 S 表示你起始的位置, 0表示初始箱子的位置, E表示预期箱子的位置，你可以走到箱子的上下左右任意一侧, 将箱子向另一侧推动。如下图将箱子向右推动一格;
 * ..S0.. -> ...S0.
 * <p>
 * 注意不能将箱子推动到'#'上, 也不能将箱子推出边界;
 * <p>
 * 现在, 给你游戏的初始样子, 你需要输出最少几步能够完成游戏, 如果不能完成, 则输出-1。
 * <p>
 * <p>
 * 输入描述:
 * 第一行为2个数字,n, m, 表示游戏盘面大小有n 行m 列(5< n, m < 50);
 * 后面为n行字符串,每行字符串有m字符, 表示游戏盘面;
 * <p>
 * 输出描述:
 * 一个数字,表示最少几步能完成游戏,如果不能,输出-1;
 * <p>
 * 输入例子1:
 * 3 6
 * .S#..E
 * .#.0..
 * ......
 * <p>
 * 输出例子1:
 * 11
 *
 * @author: 小栗旬
 * @Date: 2019/10/8 13:43
 */
public class ByteDance2018Server3A {
    static char[][] matrix;
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();

        int peopleIndexX = 0;
        int peopleIndexY = 0;

        int boxIndexX = 0;
        int boxIndexY = 0;
        matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 'S') {
                    peopleIndexX = i;
                    peopleIndexY = j;
                } else if (matrix[i][j] == '0') {
                    boxIndexX = i;
                    boxIndexY = j;
                }
            }
        }
        System.out.println(move(peopleIndexX, peopleIndexY, boxIndexX, boxIndexY));

    }

    private static int move(int x, int y, int boxX, int boxY) {
        BoxNode start = new BoxNode(x, y, boxX, boxY);
        boolean[][][][] isVisited = new boolean[n][m][n][m];
        //分别是右，下，左，上
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<BoxNode> queue = new LinkedList<>();
        start.step = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            BoxNode cur = queue.poll();
            int newBx = cur.boxX;
            int newBy = cur.boxY;
            for (int i = 0; i < 4; i++) {
                //--计算箱子的位置--
                //在箱子上面或者下面
                if (cur.y == cur.boxY) {
                    newBx = cur.x + dir[i][0] == cur.boxX ? cur.boxX + dir[i][0] : cur.boxX;
                }

                //在箱子左边或者右边
                if (cur.x == cur.boxX) {
                    newBy = cur.y + dir[i][1] == cur.boxY ? cur.boxY + dir[i][1] : cur.boxY;
                }
                //--计算箱子的位置--

                BoxNode next = new BoxNode(cur.x + dir[i][0], cur.y + dir[i][1], newBx, newBy);
                if (next.x < 0 || next.x >= n || next.y < 0 || next.y >= m || matrix[next.x][next.y] == '#'
                        || next.boxX < 0 || next.boxX >= n || next.boxY < 0 || next.boxY >= m
                        || matrix[next.boxX][next.boxY] == '#') {
                    continue;
                }
                if (!isVisited[next.x][next.y][next.boxX][next.boxY]) {
                    isVisited[next.x][next.y][next.boxX][next.boxY] = true;
                    next.step = cur.step + 1;
                    if (matrix[next.boxX][next.boxY] == 'E') {
                        return next.step;
                    }
                    queue.add(next);
                }
            }

        }
        return -1;
    }
}

class BoxNode {
    int x;
    int y;
    int boxX;
    int boxY;
    int step;

    public BoxNode(int x, int y, int boxX, int boxY) {
        this.x = x;
        this.y = y;
        this.boxX = boxX;
        this.boxY = boxY;
    }
}

