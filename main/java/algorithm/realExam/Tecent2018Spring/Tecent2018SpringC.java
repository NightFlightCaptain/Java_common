package algorithm.realExam.Tecent2018Spring;

import java.util.Scanner;

/**
 * 【贪吃的小Q】
 * <p>
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，表示父母出差的天数N(N<=50000)和巧克力的数量M(N<=M<=100000)。
 * <p>
 * 输出描述:
 * 输出一个数表示小Q第一天最多能吃多少块巧克力。
 * <p>
 * 输入例子1:
 * 3 7
 * <p>
 * 输出例子1:
 * 4
 *
 * @author: 小栗旬
 * @Date: 2019/10/30 18:56
 */
public class Tecent2018SpringC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int high = m;
        int low = 1;
        int mid = 0;
        while (high >= low) {
            mid = low + (high - low) / 2;
            int count = eatChocolate(mid, n);
            if (count == m) {
                break;
            } else if (count < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high>=low?mid:high);
    }
    /*
    426 465
22


100 382
144
     */

    private static int eatChocolate(int firstDay, int days) {
        int totalCount = 0;
        for (int i = 0; i < days; i++) {
            totalCount += firstDay;
            firstDay = (firstDay & 1) == 0 ? firstDay / 2 : firstDay / 2 + 1;
        }
        return totalCount;
    }
}
