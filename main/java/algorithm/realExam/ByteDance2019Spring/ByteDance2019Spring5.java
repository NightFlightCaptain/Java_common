package algorithm.realExam.ByteDance2019Spring;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/1 17:34
 */
public class ByteDance2019Spring5 {

    /* 根本不会,纯粹是抄的代码 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cityNum = scanner.nextInt();
        int[][] dist = new int[cityNum][cityNum];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < cityNum; j++) {
                dist[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int V = 1 << (cityNum - 1);
        int[][] dp = new int[cityNum][V];
        /*从i出发到0城市的路径*/
        for (int i = 0; i < cityNum; i++) {
            dp[i][0] = dist[i][0];
        }

        /*去的城市集合,所有的城市集合作为一个整体被遍历.j表示的就是全部经过的城市*/
        for (int j = 1; j < V; j++) {
            /* 从i出发,走完整个j */
            for (int i = 0; i < cityNum; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                /* 看该次集合j中有没有包含i城市,如果已经包含了该城市,表示不能从该城市出发然后还要经过该城市,则continue*/
                if (((j >> (i - 1)) & 1) == 1) {
                    continue;
                }
                /*如果没有到达过i城市*/
                for (int k = 1; k < cityNum; k++) {
                    /*看能不能先到k城市*/
                    if (((j >> (k - 1)) & 1) == 1) {
                        /* 求的是从i到k,然后从k走完剩余城市的路径
                         * dp[k][j ^ (1 << (k - 1))]表示的是从k出发不经过k城市的路径,加上dist[i][k]表示的就是j集合的全部城市的全部路径
                         * */
                        dp[i][j] = Math.min(dp[i][j], dist[i][k] + dp[k][j ^ (1 << (k - 1))]);
                    }
                }

            }
        }
        System.out.println(dp[0][V - 1]);

    }
//    static boolean[] hasBenn;
//    static int n;
//    static int[][] fees;
//    static int sum = 0;
//    static int res = Integer.MAX_VALUE;
//    static int count = 1;
//    static int lastIndex = 0;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        fees = new int[n][n];
//        hasBenn = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                fees[i][j] = scanner.nextInt();
//            }
//        }
//        hasBenn[0] = true;
//        getFee(0);
//        System.out.println(res);
//    }
//
//
//
//
//    private static void getFee(int startIndex) {
//        for (int i = 0; i < n; i++) {
//            if (i == startIndex || hasBenn[i]) {
//                continue;
//            }
//            sum += fees[startIndex][i];
//            hasBenn[i] = true;
//            count++;
//            lastIndex = i;
//            getFee(i);
//            count--;
//            hasBenn[i] = false;
//            sum -= fees[startIndex][i];
//        }
//        if (count == n) {
//            res = Math.min(res, sum+fees[lastIndex][0]);
//        }
//    }
}
