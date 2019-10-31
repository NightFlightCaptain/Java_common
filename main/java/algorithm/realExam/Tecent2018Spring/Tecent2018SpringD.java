package algorithm.realExam.Tecent2018Spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【小Q的歌单】
 * <p>
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次，
 * 在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 * <p>
 * 输出描述:
 * 输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
 * <p>
 * 输入例子1:
 * 5
 * 2 3 3 3
 * <p>
 * 输出例子1:
 * 9
 *
 * @author: 小栗旬
 * @Date: 2019/10/30 19:21
 */

public class Tecent2018SpringD {

    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int a = scanner.nextInt();
        int x = scanner.nextInt();
        int b = scanner.nextInt();
        int y = scanner.nextInt();

        Cmn();
        long[] dp = new long[k + 1];
        dp[0]=1;
        for (int i = 0; i < x; i++) {
            for (int j = k; j >= a; j--) {
                dp[j] = (dp[j] + dp[j - a])%mod;
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = k; j >= b; j--) {
                dp[j] = (dp[j] + dp[j - b])%mod;
            }
        }
        System.out.println(dp[k]%mod);
    }

    private static void Cmn(){
        long[][] c = new long[101][101];
        c[0][0] =1;
        for (int i =1;i<100;i++){
            for (int j =1;j<100;j++){
                c[i][j] = c[i-1][j]+c[i-1][j-1];
            }
        }
        Arrays.stream(c).forEachOrdered(o->System.out.println(Arrays.toString(o)));
    }
}

