package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【动态规划】	【最长公共子序列】
 * <p>
 * 题目描述
 * 给定两个字符串str1和str2，输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
 * 输入描述:
 * 输出包括两行，第一行代表字符串str1，第二行代表str2。(1<=length(str1),length(str2)<=5000)
 * 输出描述:
 * 输出一行，代表他们最长公共子序列。如果公共子序列的长度为空，则输出-1。
 * 示例1
 * 输入
 * 1A2C3D4B56
 * B1D23CA45B6A
 * 输出
 * 123456
 * <p>
 * 说明
 * "123456"和“12C4B6”都是最长公共子序列，任意输出一个。
 * <p>
 * 备注:
 * 时间复杂度O(n*m)，空间复杂度O(n*m)。(n,m分别表示两个字符串长度)
 *
 * @author: 小栗旬
 * @Date: 2019/9/14 8:55
 */
public class CodeInterviewGuide31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int length1 = s1.length();
        int length2 = s2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i < length1 + 1; i++) {
            for (int j = 1; j < length2 + 1; j++) {
                int temp = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, temp);
                } else {
                    dp[i][j] = temp;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int w = length1, v = length2;
        while (w > 0 && v > 0) {
            if (dp[w][v]!=dp[w-1][v] && dp[w][v]!=dp[w][v-1]){
                stringBuilder.insert(0,s1.charAt(w-1));
                w--;
                v--;
            }else if (dp[w][v]==dp[w-1][v]){
                w--;
            }else {
                v--;
            }
        }
        System.out.println(stringBuilder);
    }
}
