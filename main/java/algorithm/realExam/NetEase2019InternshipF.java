package algorithm.realExam;

import java.util.Scanner;

/**
 * 【矩形重叠】
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * <p>
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * <p>
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 * <p>
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
 * @Date: 2019/10/11 13:12
 */
public class NetEase2019InternshipF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int[][] index = new int[n][4];
        for (int line = 0; line < 4; line++) {
            for (int i = 0; i < n; i++) {
                index[i][line] = scanner.nextInt();
            }
        }
//        for (int line = 0; line < 4; line++) {
//            String[] strings = scanner.nextLine().split(" ");
//            for (int i = 0; i < n; i++) {
//                index[i][line] = Integer.valueOf(strings[i]);
//            }
//        }

        int resCount = 1;
        /* 最后形成的公共区域的四个点一定是由矩形的边相交形成的交点或者是矩形本身的四个角，
        我们找出所有可能是最终区域的矩形的左下角的点，判断这个点在多少个矩形当中 */
        for (int i = 0; i < n; i++) {
            int x = index[i][0];
            for (int j = 0; j < n; j++) {
                int y = index[j][1];
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (x >= index[k][0] && x < index[k][2] && y >= index[k][1] && y < index[k][3]) {
                        count++;
                    }
                }
                if (count > resCount) {
                    resCount = count;
                }
            }
        }
        System.out.println(resCount);

    }
}

