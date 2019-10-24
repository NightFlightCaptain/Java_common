package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【字符串的交错组成】
 * <p>
 * 题目描述
 * 给定三个字符串str1、str2 和aim,如果aim包含且仅包含来自str1和str2的所有字符，
 * 而且在aim中属于str1的字符之间保持原来在str1中的顺序，属于str2的字符之间保持原来在str2中的顺序，
 * 那么称aim是str1和str2的交错组成。实现一个函数，判断aim是否是str1和str2交错组成，如果是请输出“YES”，否则输出“NO”。
 * <p>
 * 输入描述:
 * 输出三行，分别表示三个字符串str1，str2和aim。1≤length(str1),length(str2)≤5000,1≤length(aim)≤10000，length()表示字符串长度。
 * 输出描述:
 * 输出“YES”或者“NO”。（不包含引号）
 * <p>
 * 示例1
 * 输入
 * AB
 * 12
 * 1AB2
 * 输出
 * YES
 * <p>
 * 示例2
 * 输入
 * 2019
 * 9102
 * 22001199
 * 输出
 * NO
 * <p>
 * 备注:
 * 时间复杂度O(n∗m),空间复杂度O(min(n,m))。（n表示字符串str1长度，m表示s字符串tr2长度）
 *
 * @author: 小栗旬
 * @Date: 2019/10/24 21:04
 */
public class CodeInterviewGuide44 {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String aim = scanner.nextLine();

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int shortLength = str1.length();
        int longLength = str2.length();
if (shortLength + longLength != aim.length()) {
            System.out.println("NO");
            return;
        }
        int[] dp = new int[shortLength + 1];

        for (int j = 1; j < shortLength + 1; j++) {
            if (aim.charAt(dp[j - 1]) == str1.charAt(j - 1)) {
                dp[j] = dp[j - 1] + 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < longLength; i++) {
            for (int j = 0; j < shortLength + 1; j++) {
                if (j == 0) {
                    if (aim.charAt(dp[0]) == str2.charAt(i)) {
                        dp[j] = dp[j] + 1;
                    } else {
                        dp[j] = 0;
                    }
                } else {
                    int temp1 = 0;
                    int temp2 = 0;
                    if (aim.charAt(dp[j - 1]) == str1.charAt(j - 1)) {
                        temp1 = dp[j - 1] + 1;
                    }
                    if (aim.charAt(dp[j]) == str2.charAt(i)) {
                        temp2 = dp[j] + 1;
                    }
                    dp[j] = Math.max(temp1, temp2);
                }
            }
        }
        if (dp[shortLength] == aim.length()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        * */
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String aim = scanner.nextLine();

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        int shortLength = str1.length();
        int longLength = str2.length();

        if (shortLength + longLength != aim.length()) {
            System.out.println("NO");
            return;
        }
        boolean[] dp = new boolean[shortLength + 1];

        dp[0] = true;
        for (int j = 1; j < shortLength + 1; j++) {
            if (aim.charAt(j - 1) != str1.charAt(j - 1)) {
                break;
            }
            dp[j] = true;
        }
        for (int i = 1; i < longLength + 1; i++) {
            dp[0] = dp[0] && aim.charAt(i - 1) == str2.charAt(i - 1);
            for (int j = 1; j < shortLength + 1; j++) {
                boolean touchable = (str2.charAt(i-1) == aim.charAt(i + j - 1) && dp[j])
                        || str1.charAt(j - 1) == aim.charAt(i + j - 1) && dp[j - 1];
                if (touchable) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        if (dp[shortLength]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
