package algorithm.realExam.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2020/3/20 9:11
 */
public class AliTest6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        Arrays.sort(strings);
        int res = 0;
        int[] counts = new int[26];
        for (int i = 0; i < n; i++) {
            String s = strings[i];
            int strLen = s.length();

            char charStart = s.charAt(0);
            char charEnd = s.charAt(strLen - 1);

            int lastCount;
            int index = charStart - 'a';
            while (index >= 0 && counts[index] == 0) {
                index--;
            }
            lastCount = index < 0 ? counts[0] : counts[index];
            for (int j = index; j < charStart - 'a' && j>=0; j++) {
                counts[j] = lastCount;
            }

            counts[charEnd - 'a'] = Math.max(counts[charEnd - 'a'], lastCount + strLen);

            res = Math.max(counts[charEnd - 'a'], res);
        }
        System.out.println(res);
    }

}
