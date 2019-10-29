package algorithm.realExam.ByteDance2018Server4;

import java.util.Scanner;

/**
 * 【球队分数能否打平】
 * <p>
 * 有三只球队，每只球队编号分别为球队1，球队2，球队3，这三只球队一共需要进行 n 场比赛。现在已经踢完了k场比赛，每场比赛不能打平，踢赢一场比赛得一分，输了不得分不减分。已知球队1和球队2的比分相差d1分，球队2和球队3的比分相差d2分，每场比赛可以任意选择两只队伍进行。求如果打完最后的 (n-k) 场比赛，有没有可能三只球队的分数打平。
 * <p>
 * 输入描述:
 * 第一行包含一个数字 t (1 <= t <= 10)
 * 接下来的t行每行包括四个数字 n, k, d1, d2(1 <= n <= 10^12; 0 <= k <= n, 0 <= d1, d2 <= k)
 * <p>
 * 输出描述:
 * 每行的比分数据，最终三只球队若能够打平，则输出“yes”，否则输出“no”
 * <p>
 * 输入例子1:
 * 2
 * 3 3 0 0
 * 3 3 3 3
 * <p>
 * 输出例子1:
 * yes
 * no
 * <p>
 * 例子说明1:
 * case1: 球队1和球队2 差0分，球队2 和球队3也差0分，所以可能的赛得分是三只球队各得1分
 * case2: 球队1和球队2差3分，球队2和球队3差3分，所以可能的得分是 球队1得0分，球队2得3分, 球队3 得0分，比赛已经全部结束因此最终不能打平。
 *
 * @author: 小栗旬
 * @Date: 2019/10/10 9:02
 */
public class ByteDance2018Server4A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            long d1 = scanner.nextLong();
            long d2 = scanner.nextLong();

            if (n % 3 != 0) {
                System.out.println("no");
                continue;
            }
            //如果能完成，每个队伍的最后得分为res
            long res = n / 3;
            //执行完k次可能有4种情况，求出这4种情况是否可能出现
            long[][] dir = new long[][]{{d1, d2}, {d1, -d2}, {-d1, d2}, {-d1, -d2}};
            boolean finished = false;
            for (int j = 0; j < 4; j++) {
                if ((k - dir[j][0] - dir[j][1]) % 3 == 0) {
                    //执行完k次 第2只队伍的得分
                    long second = (k - dir[j][0] - dir[j][1]) / 3;
                    //求出当前k次执行完的情况是否可能出现
                    if (second >= 0 && second + dir[j][0] >= 0 && second + dir[j][1] >= 0) {
                        //当前每个组的分数不能比最终的结果高
                        if (res >= second && res >= dir[j][0] + second && res >= dir[j][1] + second) {
                            finished = true;
                            break;
                        }

                    }
                }
            }
            if (finished) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
        scanner.close();


    }
}
