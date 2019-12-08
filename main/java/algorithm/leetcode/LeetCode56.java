package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【合并区间】
 * <p>
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/8 13:08
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            } else {
                return o1[1] - o2[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        int length = intervals.length;
        if (length == 0) {
            return list.toArray(new int[0][]);
        }
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] <= end && intervals[i][1] > end) {
                end = intervals[i][1];
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        LeetCode56 solution = new LeetCode56();
        int[][] arrays = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(solution.merge(arrays)));
        arrays = new int[][]{
                {1, 4},
                {4, 5}
        };
        System.out.println(Arrays.deepToString(solution.merge(arrays)));
        arrays = new int[][]{
                {8, 10},
                {1, 3},
                {16, 17},
                {15, 18}
        };
        System.out.println(Arrays.deepToString(solution.merge(arrays)));
        arrays = new int[][]{
                {8, 10},
                {1, 3},
                {16, 16},
                {17, 17},
                {18, 18}
        };
        System.out.println(Arrays.deepToString(solution.merge(arrays)));
    }
}
