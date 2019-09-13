package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【动态规划】 【信封嵌套问题】
 * <p>
 * 题目描述
 * 给n个信封的长度和宽度。如果信封A的长和宽都小于信封B，那么信封A可以放到信封B里，请求出信封最多可以嵌套多少层。
 * 输入描述:
 * 输出包含多行，第一行包括一个整数，代表信封的个数n(1<=n<=10^5)。接下来n行，每行两个整数l_i和w_i，代表信封的长度和宽度(−1e9<=li,wi<=1e9)。
 * 输出描述:
 * 输出包括一行，代表信封最多嵌套多少层。
 * 示例1
 * 输入
 * 9
 * 3 4
 * 2 3
 * 4 5
 * 1 3
 * 2 2
 * 3 6
 * 1 2
 * 3 2
 * 2 4
 * 输出
 * 4
 * 说明
 * 从里到外分别是{1，2}，{2，3}，{3，4}，{4，5}。
 * <p>
 * 示例2
 * 输入
 * 2
 * 1 4
 * 4 1
 * 输出
 * 1
 * 备注:
 * 时间复杂度O(nlogn)，空间复杂度O(n)。
 *
 * @author: 小栗旬
 * @Date: 2019/9/7 10:26
 */
public class CodeInterviewGuide29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] nums = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        /* Arrays.sort本身使用的是快速排序 */
        Arrays.sort(nums, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        int[] arr = new int[n];
        for (int i =0;i<n;i++){
            arr[i]=nums[i][1];
        }
        getDp3(arr);

    }

    private static void getDp3(int[] arr) {
        int length = arr.length;
        int[] ends = new int[length];
        int[] dp = new int[length];
        int boundary = 1;

        dp[0] = 1;
        ends[0] = arr[0];
        int maxCount = 1;
        for (int i = 1; i < length; i++) {

            int left = 0;
            int right = boundary - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (ends[mid] > arr[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            ends[left] = arr[i];
            dp[i] = left + 1;
            if (left == boundary) {
                boundary++;
            }
            if (dp[i] >= maxCount) {
                maxCount = dp[i];
            }
        }
        System.out.println(maxCount);
    }

}
