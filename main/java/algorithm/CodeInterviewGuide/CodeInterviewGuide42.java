package algorithm.CodeInterviewGuide;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 【动态规划】【子数组异或和为0的最多划分】
 * 题目描述
 * 给定一个整型数组arr，其中可能有正有负有零。你可以随意把整个数组切成若干个不相容的子数组，求异或和为0的子数组最多可能有多少个？整数异或和定义：把数组中所有的数异或起来得到的值。
 * 输入描述:
 * 输出包括两行，第一行一个整数，代表数组长度(1≤n≤10^6)。
 * 第二行有n个整数，代表数组(−1e9≤arr_i≤1e9)。
 * 输出描述:
 * 输出一个整数，表示数组切割最多的子数组的个数。
 * 示例1
 * 输入
 * 10
 * 3 2 1 9 0 7 0 2 1 3
 * 输出
 * 4
 * 说明
 * 最优划分：{3,2,1},{9},{0},{7},{0},{2,1,3} 其中{3,2,1},{0},{0},{2,1,3}的异或和为0
 * 备注:
 * 时间复杂度O(n)，空间复杂度O(n)。
 *
 * @author: 小栗旬
 * @Date: 2019/9/21 15:49
 */
public class CodeInterviewGuide42 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //map中key为到当前位置的异或和，value为最右边的坐标
        HashMap<Integer, Integer> map = new HashMap<>();
        //dp中存放到当前位置的最大子数组的个数
        int[] dp = new int[n];
        //看第一个数是否为0
        dp[0] = nums[0] == 0 ? 1 : 0;
        //将异或和为0存入map
        map.put(0, -1);
        map.put(nums[0], 0);
        int cur = nums[0];
        for (int i = 1; i < n; i++) {
            cur = cur ^ nums[i];
//            如果当前的异或和已经存在过,那么从之前存在的那个位置到当前位置的异或和就为0
            if (map.containsKey(cur)) {
                int indexPre = map.get(cur);
                dp[i] = indexPre == -1 ? 1 : dp[indexPre] + 1;
            }
            map.put(cur, i);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        System.out.println(dp[n - 1]);

    }
}
