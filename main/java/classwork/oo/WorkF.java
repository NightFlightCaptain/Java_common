package classwork.oo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 9:05
 */
public class WorkF {
    private static int[] limits = new int[]{8, 5, 3};
    private static int count = 0;
    private static List<Set<String>> methods = new ArrayList<>();

    public static void main(String[] args) {
        change(new int[]{8, 0, 0}, new LinkedHashSet<>());
        System.out.println("共" + count + "种方式");
        for (Set<String> steps : methods) {
            System.out.println("");
            for (String step : steps) {
                System.out.println(step);
            }
            System.out.println("\n\n");
        }
    }

    public static void change(int[] array, Set<String> steps) {
        String str = array[0] + ", " + array[1] + ", " + array[2];
        if (steps.contains(str)) {
            return;
        }
        if (array[0] == 4 && array[1] == 4) {
            steps.add("4, 4, 0");
            methods.add(steps);
            count++;
            return;
        }
        // 遍历出水桶
        for (int i = 0; i < array.length; i++) {
            // 水桶没有水, 只能被注入
            if (array[i] == 0) {
                continue;
            }
            // 遍历进水桶
            for (int j = 0; j < array.length; j++) {
                int[] temp = array.clone();
                // 不能是自己
                if (i != j) {
                    // 被注入的桶已经满了
                    if (array[j] == limits[j]) {
                        continue;
                    }
                    // 要么把进水桶注满, 要么把出水桶的水用完
                    int change = limits[j] - array[j];
                    if (array[i] < change) {
                        change = array[i];
                    }
                    // 进水桶进水
                    temp[j] = temp[j] + change;
                    // 出水桶出水
                    temp[i] = temp[i] - change;
                    // copy之前步骤, 做备份
                    Set<String> stepsTemp = new LinkedHashSet<>();
                    stepsTemp.addAll(steps);
                    // 记录此步骤
                    stepsTemp.add(str);
                    change(temp, stepsTemp);
                }
            }
        }
    }
}
