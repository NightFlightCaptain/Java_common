package algorithm.realExam.ByteDance2018Server4;

import java.util.Scanner;

/**
 * 【字符替换】
 * <p>
 * 有一个仅包含’a’和’b’两种字符的字符串s，长度为n，每次操作可以把一个字符做一次转换（把一个’a’设置为’b’，或者把一个’b’置成’a’)；但是操作的次数有上限m，问在有限的操作数范围内，能够得到最大连续的相同字符的子串的长度是多少。
 * <p>
 * 输入描述:
 * 第一行两个整数 n , m (1<=m<=n<=50000)，第二行为长度为n且只包含’a’和’b’的字符串s。
 * <p>
 * 输出描述:
 * 输出在操作次数不超过 m 的情况下，能够得到的 最大连续 全’a’子串或全’b’子串的长度。
 * <p>
 * 输入例子1:
 * 8 1
 * aabaabaa
 * <p>
 * 输出例子1:
 * 5
 * <p>
 * 例子说明1:
 * 把第一个 'b' 或者第二个 'b' 置成 'a'，可得到长度为 5 的全 'a' 子串。
 *
 * @author: 小栗旬
 * @Date: 2019/10/10 9:27
 */
public class ByteDance2018Server4B {

    public static void main(String[] args) {
        int resCount = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.nextLine();

        char[] chars = line.toCharArray();

        int[] countAs = new int[n + 1];
        countAs[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            if (chars[i - 1] == 'a') {
                countAs[i] = countAs[i - 1] + 1;
            } else {
                countAs[i] = countAs[i - 1];
            }
        }

        int left = 0, right = n;
        int mid;
        while (left <= right) {
            //mid其实是符合要求的长度
            mid = left + (right - left) / 2;
            boolean full = false;
            for (int i = 0; i + mid <= n; i++) {
                int numA = countAs[i + mid] - countAs[i];
                int numB = mid - numA;
                if (numA <= m || numB <= m) {
                    full = true;
                    break;
                }
            }
            if (full) {
                left = mid + 1;
                resCount = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(resCount);
    }


}
