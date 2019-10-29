package algorithm.realExam.ByteDance2017InternshipServer;

import java.util.Scanner;

/**
 * 【或与加】
 * <p>
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * <p>
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据为两个正整数 x , k。 满足 0 < x , k ≤ 2,000,000,000。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数y。
 * <p>
 * <p>
 * 输入例子1:
 * 5 1
 * <p>
 * 输出例子1:
 * 2
 *
 * @author: 小栗旬
 * @Date: 2019/10/29 11:14
 */
public class ByteDance2017InternshipServerD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long k = scanner.nextLong();

        long res = 0;
        long cur = 1;
        /*  1、满足条件得到的y值必须是和x每一位（转化成二进制）都不相同
        2、所以实际上就是x转化为二进制时为0的位依此提取出来依此增大的过程
        3、第k小实际上就是把k转为二进制依此填入到x为0的位里面去 ，
        例如k=5,转为二进制就是101，那么就是把1填到x从右往左第一个为0的位，把0填到x从右往左第二个为0的位，把1填到x从右往左第三个为0的位*/

        while (k > 0) {
            if ((x & cur) == 0) {
                res += cur * (k & 1);
                k >>= 1;
            }
            cur <<= 1;
        }
        System.out.println(res);
    }
}
