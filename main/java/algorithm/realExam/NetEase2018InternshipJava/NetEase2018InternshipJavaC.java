package algorithm.realExam.NetEase2018InternshipJava;

import java.util.Scanner;

/**
 * 【矩形重叠】
 * <p>
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * <p>
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * <p>
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 * <p>
 * 输入描述:
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 * <p>
 * 输出描述:
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 * <p>
 * 输入例子1:
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 * <p>
 * 输出例子1:
 * 2
 *
 * @author: 小栗旬
 * @Date: 2019/11/1 17:22
 */
public class NetEase2018InternshipJavaC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i] = scanner.nextInt();
        }

        int resCount = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (include(x1, y1, x2, y2, k, x1[i], y1[j])) {
                        count++;
                    }
                }
                resCount = Math.max(count, resCount);
            }
        }
        System.out.println(resCount);
//        int[] xAll = new int[2 * n];
//        int[] yAll = new int[2 * n];
//        System.arraycopy(x1, 0, xAll, 0, n);
//        System.arraycopy(x2, 0, xAll, n, n);
//
//        System.arraycopy(y1, 0, yAll, 0, n);
//        System.arraycopy(y2, 0, yAll, n, n);

    }

    private static boolean include(int[] x1, int[] y1, int[] x2, int[] y2, int k, int x, int y) {
        if (x >= x1[k] && y >= y1[k] && x < x2[k] && y < y2[k]) {
            return true;
        }
        return false;
    }
}
