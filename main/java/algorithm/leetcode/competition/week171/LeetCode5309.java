package algorithm.leetcode.competition.week171;

/**
 * 【1319 连通网络的操作次数】
 * <p>
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 * <p>
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 * <p>
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 * <p>
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 *
 * @author: 小栗旬
 * @Date: 2020/1/12 10:57
 */
public class LeetCode5309 {

    public int makeConnected(int n, int[][] connections) {
        return unionMethod(n, connections);
    }

    /* 并查集 将能够联通的点作为一个整体，其中的每个点都连向同一个点，一般可以是最后进入整体的点 */

    private int unionMethod(int n, int[][] connections) {
        int lineCount = connections.length;
        if (lineCount < n - 1) {
            return -1;
        }
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        int ans = n - 1;
        for (int i = 0; i < lineCount; i++) {
            int p = find(connections[i][0], father);
            int q = find(connections[i][1], father);
            if (p != q) {
                father[p] = q;
                ans--;
            }

        }
        return ans;
    }

    /**
     * 表示x与哪个点联通，将能联通的点作为一个整体，所有点都连向最后一个进入这个整体的点
     *
     * @param x
     * @param father
     * @return
     */
    private int find(int x, int[] father) {
        if (x != father[x]) {
            father[x] = find(father[x], father);
        }
        return father[x];
    }


    /**
     * dfs方法，无法通过时间复杂度
     *
     * @param n
     * @param connections
     * @return
     */
    private int dfsMethod(int n, int[][] connections) {
        int lineCount = connections.length;
        if (lineCount < n - 1) {
            return -1;
        }
        boolean[] isConnected = new boolean[n];

        int setCount = 0;
        for (int i = 0; i < lineCount; i++) {
            if (!isConnected[connections[i][0]]) {
                dfs(connections, isConnected, connections[i][0]);
                setCount++;
            }
        }
        int count = 0;
        for (boolean b : isConnected) {
            if (!b) {
                count++;
            }
        }
        return count + setCount - 1;
    }

    private void dfs(int[][] connections, boolean[] isConnected, int m) {
        if (isConnected[m]) {
            return;
        }
        int lineCount = connections.length;
        isConnected[m] = true;
        for (int i = 0; i < lineCount; i++) {
            int[] connection = connections[i];
            if (connection[0] == m) {
                dfs(connections, isConnected, connection[1]);
            } else if (connection[1] == m) {
                dfs(connections, isConnected, connection[0]);
            }

        }
    }

    public static void main(String[] args) {
        LeetCode5309 solution = new LeetCode5309();
        System.out.println(solution.makeConnected(6, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
        }) == 2);
        System.out.println(solution.makeConnected(6, new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}
        }) == -1);
        System.out.println(solution.makeConnected(4, new int[][]{
                {0, 1}, {0, 2}, {1, 2}
        }) == 1);
        System.out.println(solution.makeConnected(5, new int[][]{
                {0, 1}, {0, 2}, {3, 4}, {2, 3}
        }) == 0);
        System.out.println(solution.makeConnected(100, new int[][]{

                {17, 51}, {33, 83}, {53, 62}, {25, 34}, {35, 90}, {29, 41}, {14, 53}, {40, 84}, {41, 64}, {13, 68}, {
                44, 85}, {57, 58}, {50, 74}, {20, 69}, {15, 62}, {25, 88}, {4, 56}, {37, 39}, {30, 62}, {69, 79}, {33, 85}, {24, 83}, {
                35, 77}, {2, 73}, {6, 28}, {46, 98}, {11, 82}, {29, 72}, {67, 71}, {12, 49}, {42, 56}, {56, 65}, {40, 70}, {24, 64}, {29, 51}, {
                20, 27}, {45, 88}, {58, 92}, {60, 99}, {33, 46}, {19, 69}, {33, 89}, {54, 82}, {16, 50}, {35, 73}, {19, 45}, {19, 72}, {
                1, 79}, {27, 80}, {22, 41}, {52, 61}, {50, 85}, {27, 45}, {4, 84}, {11, 96}, {0, 99}, {29, 94}, {9, 19}, {66, 99}, {20, 39}, {
                16, 85}, {12, 27}, {16, 67}, {61, 80}, {67, 83}, {16, 17}, {24, 27}, {16, 25}, {41, 79}, {51, 95}, {46, 47}, {27, 51}, {
                31, 44}, {0, 69}, {61, 63}, {33, 95}, {17, 88}, {70, 87}, {40, 42}, {21, 42}, {67, 77}, {33, 65}, {3, 25}, {39, 83}, {34, 40}, {
                15, 79}, {30, 90}, {58, 95}, {45, 56}, {37, 48}, {24, 91}, {31, 93}, {83, 90}, {17, 86}, {61, 65}, {15, 48}, {34, 56}, {
                12, 26}, {39, 98}, {1, 48}, {21, 76}, {72, 96}, {30, 69}, {46, 80}, {6, 29}, {29, 81}, {22, 77}, {85, 90}, {79, 83}, {6, 26}, {
                33, 57}, {3, 65}, {63, 84}, {77, 94}, {26, 90}, {64, 77}, {0, 3}, {27, 97}, {66, 89}, {18, 77}, {27, 43}
        }) == 13);
    }
}
