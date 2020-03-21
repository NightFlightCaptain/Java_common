package algorithm.realExam.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2020/3/19 19:36
 */
public class MeiTuan2020Spring4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int[][] lens = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(lens[i], Integer.MAX_VALUE);
            lens[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int length = scanner.nextInt();
            lens[start - 1][end - 1] = length;
            lens[end - 1][start - 1] = length;

        }
        int k = scanner.nextInt();
        int[][] shortLens = getSmall(lens, n);
        boolean[] hasBeen = new boolean[m];

        int count = isSmall(s - 1, n, k, shortLens, hasBeen);
        System.out.println(count);
    }

    private static int isSmall(int start, int end, int walk, int[][] shortLens, boolean[] hasBeen) {
        int count = 0;
        for (int i = 0; i < end; i++) {
            if (!hasBeen[i]) {
                if (shortLens[start][i] >= walk) {
                    count++;
                } else {
                    hasBeen[i] = true;
                    count += isSmall(i, end, walk - shortLens[start][i], shortLens, hasBeen);
                }
            }
        }
        return count;
    }

    private static int[][] getSmall(int[][] graph, int n) {
        int[][] edge = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = graph[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (edge[i][j] > edge[i][k] + edge[k][j]) {
                        edge[i][j] = edge[i][k] + edge[k][j];
                    }
                }
            }
        }
        return edge;
    }
}

