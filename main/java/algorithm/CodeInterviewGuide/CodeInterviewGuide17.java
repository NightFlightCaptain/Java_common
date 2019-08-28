package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【机器人达到指定位置方法数】
 * <p>
 * 题目描述
 * 假设有排成一行的N个位置，记为1~N，开始时机器人在M位置，机器人可以往左或者往右走，如果机器人在1位置，那么下一步机器人只能走到2位置，
 * 如果机器人在N位置，那么下一步机器人只能走到N-1位置。规定机器人只能走k步，最终能来到P位置的方法有多少种。
 * 由于方案数可能比较大，所以答案需要对1e9+7取模。
 * <p>
 * 输入描述:
 * 输出包括一行四个正整数N（2<=N<=5000）、M(1<=M<=N)、K(1<=K<=5000)、P(1<=P<=N)。
 * 输出描述:
 * 输出一个整数，代表最终走到P的方法数对10^9+7取模后的值。
 * <p>
 * 示例1
 * 输入
 * 5 2 3 3
 * 输出
 * 3
 * 说明
 * 1).2->1,1->2,2->3
 * <p>
 * 2).2->3,3->2,2->3
 * <p>
 * 3).2->3,3->4,4->3
 * <p>
 * 示例2
 * 输入
 * 1000 1 1000 1
 * 输出
 * 591137401
 * 说明
 * 注意答案要取模
 * 备注:
 * 时间复杂度O(n*k),空间复杂度O(N)。
 *
 * @author: 小栗旬
 * @Date: 2019/8/28 12:48
 */
public class CodeInterviewGuide17 {
    static int N;
    static int M;
    static int K;
    static int P;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        P = scanner.nextInt();

        long totalCount = 0;
        //count数组表示从每一个位置到达目标位置的方法个数，
        // 虽然要确定方法个数要需要剩余能走多少步才能确定，但是这一点我们可以通过循环用一个变量来解决，这要是时间换空间的想法
        long[] count = new long[N + 1];
        if (P == 1) {
            count[2] = 1;
        } else if (P == N) {
            count[P - 1] = 1;
        } else {
            count[P - 1] = 1;
            count[P + 1] = 1;
        }
        for (int i = 2; i <= K; i++) {
            long[] nCount = new long[N + 1];
            for (int j = 1; j < N + 1; j++) {
                if (j == 1) {
                    nCount[j] = count[j + 1];
                } else if (j == N) {
                    nCount[j] = count[j - 1];
                } else {
                    nCount[j] = (count[j - 1] + count[j + 1])% (int)(Math.pow(10, 9) + 7);
                }
            }
            count= nCount;
        }
        totalCount = count[M];
        System.out.println(Integer.valueOf(String.valueOf(totalCount % (int)(Math.pow(10, 9) + 7))));

    }

}
