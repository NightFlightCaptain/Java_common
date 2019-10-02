package algorithm.realExam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/2 10:18
 */
public class ByteDance2019Spring4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int M = scanner.nextInt();
        scanner.nextLine();
        int[][][] snapshots = new int[M][][];
        for (int i = 0; i < M; i++) {
            String[] line = scanner.nextLine().split(" ");
            snapshots[i]= new int[Integer.valueOf(line[0])][2];
            for (int j = 0; j < Integer.valueOf(line[0]); j++) {
                snapshots[i][j][0] = Integer.valueOf(line[1 + j * 2]);
                snapshots[i][j][1] = Integer.valueOf(line[2 + j * 2]);
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> lashMap = new HashMap<>();
        int maxCount =1;
        for (int i = 0; i < M; i++) {
            map.clear();
            for (int j = 0; j < snapshots[i].length; j++) {
                map.put(snapshots[i][j][0] + " " + snapshots[i][j][1], 1);
            }
            for (String key : map.keySet()) {
                if (lashMap.containsKey(key)) {
                    map.put(key, lashMap.get(key) + 1);
                    maxCount = Math.max(maxCount,map.get(key));
                }
            }
            lashMap.clear();
            lashMap.putAll(map);
        }
        System.out.println(maxCount);
    }
}
