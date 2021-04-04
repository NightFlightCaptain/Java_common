package algorithm.realExam.MeiTuan2021Internship;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/4/4 10:21
 * <p>
 * 题目描述：
 * 小美在路上看到一些小学生在玩跳方格，她也想跟着一起玩。
 * <p>
 * 这个方格被划分为n×n的小方格，即有n行n列。每一个小方格上面都是一个1~k的正整数。小美想依次从1,2,…,k这个顺序来跳。一开始小美可以站在任意一个小方格。从一个方格跳到另一个方格的花费为两个方格的曼哈顿距离。小美想知道是否可以依照该顺序一直跳到k，如果可以，最小的总花费是多少。
 * <p>
 * 两个格子(x1,y1),(x2,y2)的曼哈顿距离为：|x1-x2|+|y1-y2|。例如(3,4),(1,6)的曼哈顿距离为|3-1|+|4-6|=4。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行两个正整数n,k；
 * <p>
 * 接下来n行n列，表示该方格。每个数字都在1~k的范围内。
 * <p>
 * 1≤n≤50，1≤k≤n2
 * <p>
 * 输出描述
 * 如果不可能完成，输出-1；否则，输出最小总花费。
 * <p>
 * <p>
 * 样例输入
 * 2 2
 * 1 2
 * 2 1
 * 样例输出
 * 1
 * <p>
 * 提示
 * 小美从(1,1)跳到(1,2)，花费为1。
 * <p>
 * 输入样例2
 * 4 4
 * 1 2 2 1
 * 2 4 4 1
 * 4 4 4 2
 * 1 1 1 2
 * 输出样例2
 * -1
 * 样例解释2
 * 小美不可能依照该顺序跳到4。
 */
public class MeiTuan2021Internship4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] nums = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        System.out.println(k);
    }
}

