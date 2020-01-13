package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【课程表】
 * <p>
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 说明:
 * <p>
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 * <p>
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/13 20:01
 */
public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return bfsMethod(numCourses, prerequisites);
    }

    private boolean bfsMethod(int numCourses, int[][] prerequisites) {
        // indegrees 表示入度表，即什么时候能入度，即该点已经完成。对于该题来说，表示每门课有几门先修课程
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 没有先修课程即可以加入queue
            if (indegrees[i] ==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int[] prerequisite : prerequisites) {
                // 如果该门课是某门课的先修课程，则这门课程的先修课程-1
                if (prerequisite[1] == course) {
                    // 当这门课没有先修课程的时候就可以加入queue了
                    if (--indegrees[prerequisite[0]] == 0) {
                        queue.add(prerequisite[1]);
                    }
                }
            }
        }
        return numCourses ==0;
    }

    /* dfs解法，dfs需要循环，每一次循环都是需要使用递归。
     * 【注意】每一次外层循环，实际上都表示的是一个全部相连的点能否连通，而不表示每一个点的状态
     * */

    private boolean dfsMethod(int numCourses, int[][] prerequisites) {
        int[] hasVisitedCycle = new int[numCourses];
        boolean[][] adjacency = new boolean[numCourses][numCourses];

        for (int[] prerequisite : prerequisites) {
            adjacency[prerequisite[0]][prerequisite[1]] = true;
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasVisitedCycle[i] != -1 && !dfs(i, hasVisitedCycle, adjacency)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否能完成
     *
     * @param course          当前课程
     * @param hasVisitedCycle 1表示访问了这个课程，但是还未完成，-1表示这个课程是没有问题的
     * @param adjacency       表示课程的关系
     * @return true表示能完成，false表示该课程不能完成
     */
    private boolean dfs(int course, int[] hasVisitedCycle, boolean[][] adjacency) {
        if (hasVisitedCycle[course] == 1) {
            return false;
        }
        if (hasVisitedCycle[course] == -1) {
            return true;
        }

        // 访问了该节点
        hasVisitedCycle[course] = 1;
        for (int i = 0; i < adjacency.length; i++) {
            // 访问该节点全部所需的课程节点
            if (adjacency[course][i] && !dfs(i, hasVisitedCycle, adjacency)) {
                return false;
            }
        }
        // 该节点没有问题
        hasVisitedCycle[course] = -1;
        return true;
    }

    public static void main(String[] args) {
        LeetCode207 solution = new LeetCode207();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(solution.canFinish(5, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 2}
        }));

        System.out.println(solution.canFinish(3, new int[][]{
                {0, 1}, {0, 2}, {1, 2}
        }));
        System.out.println(solution.canFinish(8, new int[][]{
                {1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}
        }));


    }
}
