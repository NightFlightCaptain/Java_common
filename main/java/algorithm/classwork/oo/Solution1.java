package algorithm.classwork.oo;

import java.util.LinkedList;

/**
 * @author: 小栗旬
 * @Date: 2019/10/19 9:19
 */
public class Solution1 {
    static int minPrice = Integer.MAX_VALUE;
    static LinkedList<Character> minPricePath = new LinkedList<>();

    public static void main(String[] args) {
        int[][] prices = new int[][]{
                {0, 7, 3, 10, 15},
                {6, 0, 5, 13, 12},
                {4, 8, 0, 5, 10},
                {9, 11, 6, 0, 11},
                {17, 14, 9, 8, 0}
        };
//        getMinPrice(prices);
//        System.out.println(minPrice);
//        System.out.println(minPricePath);
        System.out.println(dp(prices));
    }

    /* 动态规划  O(2^n*n^2) */
    private static int dp(int[][] prices) {
        int length = prices.length;
        int col = 1 << (length - 1);
        int[][] dp = new int[length][col];
        // 为第一列赋值
        for (int i = 0; i < length; i++) {
            dp[i][0] = prices[i][0];
        }

        // j代表的是还未走过的城市
        for (int j = 1; j < col; j++) {
            // i代表的是当前城市
            for (int i = 0; i < length; i++) {
                dp[i][j] = 0x7ffff;
                // 判断是否走过该城市，如果已经走过就continue
                if (((j >> (i - 1)) & 1) == 1) {
                    continue;
                }

                for (int k = 0; k < length; k++) {
                    //判断是否需要经过k城市，如果不需要，则continue
                    if (((j >> (k - 1)) & 1) == 0) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], prices[i][k] + dp[k][j - (1 << k - 1)]);
                }
            }
        }
        return dp[0][col-1];
    }

    /*  暴力法 BSD O(n!) */
    private static void getMinPrice(int[][] prices) {
        int length = prices.length;

        for (int startCity = 0; startCity < length; startCity++) {
            boolean[] hasBeen = new boolean[length];
            LinkedList<Character> path = new LinkedList<>();
            hasBeen[startCity] = true;
            path.clear();
            path.add((char) ('A' + startCity));
            getPrice(prices, hasBeen, path, startCity, startCity, 0);
        }
    }

    private static void getPrice(int[][] prices, boolean[] hasBeen, LinkedList<Character> path,
                                 int startCity, int curCity, int curPrice) {
        int length = prices.length;
        int cityCount = 0;
        for (int i = 0; i < length; i++) {
            if (!hasBeen[i]) {
                hasBeen[i] = true;
                curPrice += prices[curCity][i];
                path.add((char) ('A' + i));
                getPrice(prices, hasBeen, path, startCity, i, curPrice);
                curPrice -= prices[curCity][i];
                path.removeLast();
                hasBeen[i] = false;
            } else {
                cityCount++;
            }

        }
        if (cityCount == 5) {
            if (minPrice > curPrice + prices[curCity][startCity]) {
                minPrice = curPrice + prices[curCity][startCity];
                minPricePath.clear();
                minPricePath.addAll(path);
            }
        }
    }
}
