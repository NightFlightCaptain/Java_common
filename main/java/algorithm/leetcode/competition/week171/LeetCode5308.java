package algorithm.leetcode.competition.week171;

/**
 * 【1318 或运算的最小翻转次数】
 * <p>
 * 给你三个正整数 a、b 和 c。
 * <p>
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * <p>
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 * 示例 2：
 * <p>
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 *
 * @author: 小栗旬
 * @Date: 2020/1/12 10:46
 */
public class LeetCode5308 {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while (c != 0 || a != 0 || b != 0) {
            int n = (a & 1) + (b & 1);
            int m = c & 1;
            if (m != 1 || n < 1) {
                count += Math.abs(m - n);
            }
            if (a != 0) {
                a = a >> 1;
            }
            if (b != 0) {
                b = b >> 1;
            }
            if (c != 0) {
                c = c >> 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode5308 solution = new LeetCode5308();
        System.out.println(solution.minFlips(2, 6, 5));
        System.out.println(solution.minFlips(4, 2, 7));
        System.out.println(solution.minFlips(1, 2, 3));
        System.out.println(solution.minFlips(0, 0, 0));
        System.out.println(solution.minFlips(7, 7, 7));
    }
}
