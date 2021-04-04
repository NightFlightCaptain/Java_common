package algorithm.realExam.MeiTuan2021Internship;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/4/4 9:47
 */
public class MeiTuan2021Internship1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(get(s));
    }

    private static long get(String s) {
        int length = s.length();
        int[] dp = new int[length + 1];
        for (int i = 0; i < length + 1; i++) {
            dp[i] = i;
        }

        long res = length + 1;
        for (int i = 2; i < length; i++) {
            int temp;
            int last = 0;
            for (int j = 0; j < i; j++) {
                dp[j] = 0;
            }
            for (int j = i; j < length + 1; j++) {
                temp = dp[j];
                if (s.charAt(j - 1) != s.charAt(j - 2)) {
                    dp[j] = dp[j - 1] + last;
                } else {
                    dp[j] = last;
                }
                last = temp;
            }
            res += dp[length];
            res = res % 20210101;
        }
        return res;
    }


    private static void getAll(char[] chars,int i,String res){
        if (i==chars.length){
            return;
        }else {
            getAll(chars,i+1,res);
            getAll(chars,i+1,res+chars[i]);
        }

    }
}
