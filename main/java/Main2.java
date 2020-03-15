import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {


    private int[][] getUniteSet(int[][] intervals) {
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
}
