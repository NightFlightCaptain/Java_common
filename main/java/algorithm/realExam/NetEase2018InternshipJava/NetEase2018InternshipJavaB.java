package algorithm.realExam.NetEase2018InternshipJava;

import java.util.Scanner;

/**
 * 【数对】
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * <p>
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * <p>
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * <p>
 * 输入例子1:
 * 5 2
 * <p>
 * 输出例子1:
 * 7
 * <p>
 * 例子说明1:
 * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 *
 * @author: 小栗旬
 * @Date: 2019/11/1 16:44
 */
public class NetEase2018InternshipJavaB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        long count = 0;
        for (long y = k + 1; y <= n; y++) {
            count += n / y * (y - k);
            if (n % y >= k) {
                count += n % y - k + 1;
                count -= k == 0 ? 1 : 0;
            }
        }
        System.out.println(count);
    }
}
