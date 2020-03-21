package algorithm.realExam.alibaba;

public class AliTest1 {

    private int m;
    private int n;
    private int[][] array;
    private int sum = 0;
    private int max = 0;
    private final int[][] move = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private int maxBlackBlock(int[][] array) {
        this.array = array;
        m = array.length;
        if (m == 0) {
            return 0;
        }
        n = array[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <n; j++) {
                if (array[i][j] == 1) {
                    sum = 1;
                    dfs(i, j);
                    if (sum > max) {
                        max = sum;
                    }
                }
            }
        }
        return max;

    }

    private void dfs(int x, int y) {
        array[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + move[i][0];
            int nextY = y + move[i][1];
            if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                    && array[nextX][nextY] == 1) {
                sum++;
                dfs(nextX, nextY);
            }
        }
    }


}

