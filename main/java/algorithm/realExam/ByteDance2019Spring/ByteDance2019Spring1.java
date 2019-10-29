package algorithm.realExam.ByteDance2019Spring;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/1 16:24
 */
public class ByteDance2019Spring1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String str = strings[i];
            int[] dp = new int[str.length()];
            dp[0] = 1;
            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(j - 1)) {
                    int index1 = j - 1;
                    while (index1 >= 0 && dp[index1] == -1) {
                        index1--;
                    }
                    if (index1 >= 0 && dp[index1] == 2) {
                        dp[j] = -1;
                        continue;
                    }
                    index1--;
                    while (index1 >= 0 && dp[index1] == -1) {
                        index1--;
                    }
                    if (index1 >= 0 && (dp[index1] == 2)) {
                        dp[j] = -1;
                        continue;
                    }
                    dp[j]=2;

                } else {
                    dp[j] = 1;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int k=0;k<str.length();k++){
                if (dp[k]!=-1){
                    stringBuilder.append(str.charAt(k));
                }
            }
            res[i] = stringBuilder.toString();
            System.out.println(res[i]);
        }
    }
}
