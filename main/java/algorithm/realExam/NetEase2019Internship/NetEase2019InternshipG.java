package algorithm.realExam.NetEase2019Internship;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 【牛牛的闹钟】
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * <p>
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 * <p>
 * 输入例子1:
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 * <p>
 * 输出例子1:
 * 6 0
 *
 * @author: 小栗旬
 * @Date: 2019/10/11 20:23
 */
public class NetEase2019InternshipG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] alarmTime = new int[n][2];
        for (int i = 0; i < n; i++) {
            alarmTime[i][0] = scanner.nextInt();
            alarmTime[i][1] = scanner.nextInt();
        }
        /*

         */

        Arrays.sort(alarmTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        int x = scanner.nextInt();
        int[] classTime = new int[2];
        classTime[0] = scanner.nextInt();
        classTime[1] = scanner.nextInt();
        scanner.close();

        int[] startTime = new int[2];
        if (x <= classTime[1]) {
            startTime[0] = classTime[0];
            startTime[1] = classTime[1] - x;
        } else {
            int temp = x - classTime[1];
            if (temp > 60) {
                startTime[0] = classTime[0] - 2;
                startTime[1] = 2 * 60 - temp;
            } else {
                startTime[0] = classTime[0] - 1;
                startTime[1] = 60 - temp;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (alarmTime[i][0] < startTime[0]
                    || (alarmTime[i][0] == startTime[0] && alarmTime[i][1] <= startTime[1])) {
                System.out.println(alarmTime[i][0] + " " + alarmTime[i][1]);
                break;
            }
        }
    }
}
