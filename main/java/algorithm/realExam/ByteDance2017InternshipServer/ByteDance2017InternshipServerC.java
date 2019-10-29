package algorithm.realExam.ByteDance2017InternshipServer;

import java.util.Scanner;

/**
 * 【魔法权值】
 * <p>
 * 给出 n 个字符串，对于每个 n 个排列 p，按排列给出的顺序(p[0] , p[1] … p[n-1])依次连接这 n 个字符串都能得到一个长度为这些字符串长度之和的字符串。所以按照这个方法一共可以生成 n! 个字符串。
 * <p>
 * 一个字符串的权值等于把这个字符串循环左移 i 次后得到的字符串仍和原字符串全等的数量，i 的取值为 [1 , 字符串长度]。求这些字符串最后生成的 n! 个字符串中权值为 K 的有多少个。
 * <p>
 * 注：定义把一个串循环左移 1 次等价于把这个串的第一个字符移动到最后一个字符的后面。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为两个正整数 n, K ， n 的大小不超过 8 ， K 不超过 200。接下来有 n 行，每行一个长度不超过 20 且仅包含大写字母的字符串。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数代表权值为 K 的字符串数量。
 * <p>
 * <p>
 * 输入例子1:
 * 3 2
 * AB
 * RAAB
 * RA
 * <p>
 * 输出例子1:
 * 3
 *
 * @author: 小栗旬
 * @Date: 2019/10/29 10:54
 */
public class ByteDance2017InternshipServerC {
    static int k;
    static int valueKCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        /* 对于每个组成的字符串，都可以由其他n-1种移动得到。
        所以实际上只有(n-1)!中字符串，如果这个字符串满足条件，那么说明有其他n-1个字符串也满足条件
        这样我们就可以减少生成的字符串 */
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(strings[0]);
        boolean[] isChosen = new boolean[n];
        isChosen[0] = true;
        generateString(strings,stringBuilder,isChosen,1);
        System.out.println(valueKCount);
    }

    /**
     * 生成字符串，采用深度搜索的方式
     * @param strings 字符串数组
     * @param currentString 当前的字符串
     * @param isChosen 字符串是否被选择过
     * @param count 当前字符串是由多少个字符串拼接成的
     */
    private static void generateString(String[] strings, StringBuilder currentString, boolean[] isChosen, int count) {

        if (count == strings.length && getCount(currentString.toString())) {
            valueKCount += strings.length;
        }
        for (int i = 1; i < strings.length; i++) {
            if (!isChosen[i]) {
                currentString.append(strings[i]);
                isChosen[i] = true;
                count++;
                generateString(strings, currentString, isChosen, count);
                count--;
                isChosen[i] = false;
                currentString.delete(currentString.length() - strings[i].length(), currentString.length());
            }
        }
    }

    /**
     * 移动字符串，计算有多少种和原来相同的字符串，返回是否是k种
     * @param string 拼接成的字符串
     * @return 如果是k种，则返回true，否则返回false
     */
    private static boolean getCount(String string) {
        int resCount = 0;
        StringBuilder curString = new StringBuilder(string);
        int index = 0;
        while (index < string.length()) {
            char c = curString.charAt(0);
            curString.deleteCharAt(0).append(c);
            if (string.contentEquals(curString)) {
                resCount++;
                if (resCount > k) {
                    return false;
                }
            }
            index++;
        }
        if (resCount == k) {
            return true;
        } else {
            return false;
        }
    }
}
