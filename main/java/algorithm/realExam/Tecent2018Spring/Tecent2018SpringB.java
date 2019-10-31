package algorithm.realExam.Tecent2018Spring;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【纸牌游戏】
 * <p>
 * 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。
 * 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。
 * 他们的得分等于他们抽到的纸牌数字总和。
 * 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括两行。
 * 第一行包括一个正整数n(1 <= n <= 105),表示纸牌的数量。
 * 第二行包括n个正整数ai(1 <= ai <= 109),表示每张纸牌上的数字。
 * <p>
 * 输出描述:
 * 输出一个整数, 表示游戏结束后牛牛得分减去羊羊得分等于多少。
 * <p>
 * 输入例子1:
 * 3
 * 2 7 4
 * <p>
 * 输出例子1:
 * 5
 *
 * @author: 小栗旬
 * @Date: 2019/10/30 18:50
 */
public class Tecent2018SpringB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int res = 0;
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            if (((n-1 - i) & 1) == 0) {
                res += nums[i];
            } else {
                res -= nums[i];
            }
        }
        System.out.println(res);
    }
}
