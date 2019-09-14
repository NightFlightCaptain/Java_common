package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【动态规划】 【最长公共子串】
 * <p>
 * 题目描述
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * 输入描述:
 * 输入包括两行，第一行代表字符串srr1，第二行代表字符串str2。(1≤length(str1),length(str2)≤5000)
 * 输出描述:
 * 输出包括一行，代表最长公共子串。
 * 示例1
 * 输入
 * 1AB2345CD
 * 12345EF
 * 输出
 * 2345
 * 备注:
 * 时间复杂度O(n^2)，额外空间复杂度O(1)。（n可以为其中任意一个字符串长度）
 *
 * @author: 小栗旬
 * @Date: 2019/9/14 16:42
 */
public class CodeInterviewGuide33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        method2(s1, s2);
    }

    /**
     * 两个字符串排成矩阵，公共子字符串的特点是左上到右下斜着的不间断一条线
     * 我们可以从不同的起点开始逐渐往右下遍历查询子字符串
     * @param s1
     * @param s2
     */
    private static void method2(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        //斜线开始的行
        int row = 0;
        //斜线开始的列
        int col = length1 - 1;

        int end = 0;
        int maxLen = 0;
        while (row < length2) {
            int len = 0;
            int i = row, j = col;
            while (i < length2 && j <length1) {
                if (s1.charAt(j) == s2.charAt(i)) {
                    len++;
                } else {
                    len = 0;
                }
                if (len > maxLen) {
                    maxLen = len;
                    end = i;
                }
                i++;
                j++;
            }
            if (col > 0) {
                col--;
            } else {
                row++;
            }
        }
        if (maxLen == 0){
            System.out.println(-1);
        }else {
            System.out.println(s2.substring(end - maxLen + 1, end + 1));
        }
    }

    private static void method1(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 < length2) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            int length = length1;
            length1 = length2;
            length2 = length;
        }
        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();

        for (int i = 0; i < length1; i++) {
            int index1 = i, index2 = 0;
            cur = new StringBuilder();
            while (index1 < length1 && index2 < length2) {
                if (s1.charAt(index1) == s2.charAt(index2)) {
                    cur.append(s1.charAt(index1));
                    index1++;
                    index2++;
                } else {

                    if (cur.length() == 0) {
                        index1++;
                        index2++;
                    }
                    if (cur.length() > res.length()) {
                        res = cur;
                    }
                    cur = new StringBuilder();
                    index1 = i;
                }

            }
            if (cur.length() > res.length()) {
                res = cur;
            }
        }

        if (res.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }
}
