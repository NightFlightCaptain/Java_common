package algorithm.realExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/7 10:41
 */
public class ByteDance2018Server2B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(c);
        for (int i = 0; i < n; i++) {
            int colorCount = scanner.nextInt();
            for (int j = 0; j < colorCount; j++) {
                int colorNum = scanner.nextInt();
                if (!map.containsKey(colorNum)) {
                    map.put(colorNum, new ArrayList<>());
                }
                map.get(colorNum).add(i);
            }
        }

        int resCount = 0;
        for (int i = 1; i <= c; i++) {
            ArrayList<Integer> linkedList = map.get(i);
            if (linkedList == null) {
                continue;
            }
            int length = linkedList.size();
            int[] array = new int[length];
            int k = 0;
            for (int j : linkedList) {
                array[k++] = j;
            }

            for (int j = 0; j < length; j++) {
                if (j < length - 1 && array[j + 1] - array[j] < m) {
                    resCount++;
                    break;
                } else if (j == length - 1 && array[j] - array[0] < m) {
                    resCount++;
                    break;
                }
            }

        }
        System.out.println(resCount);
    }

}
