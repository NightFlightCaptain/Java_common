package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【最长递增子序列】
 * <p>
 * 题目描述
 * 给定数组arr，设长度为n，输出arr的最长递增子序列。（如果有多个答案，请输出其中字典序最小的）
 * 输入描述:
 * 输出两行，第一行包括一个正整数n（n<=100000），代表数组长度。第二行包括n个整数，代表数组(1<=arr_i<=1e9)。
 * 输出描述:
 * 输出一行。代表你求出的最长的递增子序列。
 * <p>
 * 示例1
 * 输入
 * 9
 * 2 1 5 3 6 4 8 9 7
 * 输出
 * 1 3 4 8 9
 * <p>
 * 示例2
 * 输入
 * 5
 * 1 2 8 6 4
 * 输出
 * 1 2 4
 * <p>
 * 说明
 * 其最长递增子序列有3个，（1，2，8）、（1，2，6）、（1，2，4）其中第三个字典序最小，故答案为（1，2，4）
 * <p>
 * 备注:
 * 时间复杂度O(nlogn)，空间复杂度O(n)。
 *
 * @author: 小栗旬
 * @Date: 2019/9/1 22:07
 */
public class CodeInterviewGuide25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        getDp3(nums);
    }

    private static void getDp3(int[] arr) {
        int length = arr.length;
        int[] ends = new int[length];
        int[] dp = new int[length];
        int boundary = 1;

        dp[0] = 1;
        ends[0] = arr[0];
        int maxIndex = 0;
        int maxCount = 0;
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
                maxIndex = i;
                maxCount = dp[i];
            }
        }
        int leftLength = dp[maxIndex];
        StringBuilder res = new StringBuilder();
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == leftLength) {
                res.insert(0, " " + arr[i]);
                leftLength--;
            }
        }
        System.out.println(res.substring(1));
    }


    /**
     * O(n*logn)的时间复杂度
     *
     * @param arr
     */
    private static void getDp2(int[] arr) {
        int length = arr.length;
        //dp表示以当前下标结尾的子序列的最大长度
        int[] dp = new int[length];
        //ends的下标表示的是子序列的长度，存储的是在当前长度下的子序列的最后一位的值（子序列可能有多个，去最后一位最小的值）
        //ends数组一定是递增的，3位数的最后一位的值不可能比2位数的最后一位的值小，假设它小的话，那么在3位数里取2位组成2位数的子序列
        int[] ends = new int[length];
        Arrays.fill(ends, -1);
        //ends数组不一定使用完全，用right来表示右边界
        int rightBoundary = 0;

        ends[0] = arr[0];
        dp[0] = 1;

        int maxIndex = 0, maxCount = dp[0];
        StringBuilder sb = new StringBuilder();

        //该循环的目标是求dp，使用ends数组是为了减少时间复杂度
        for (int i = 1; i < length; i++) {
            int left = 0, right = rightBoundary;
            int mid;
            while (left <= right) {
                mid = (left + right) / 2;
                if (ends[mid] <= arr[i]) {
                    left = mid + 1;
                } else if (ends[mid] > arr[i]) {
                    right = mid - 1;
                }
            }
            ends[left] = arr[i];
            dp[i] = left + 1;
            if (left > rightBoundary) {
                rightBoundary++;
            }


            if (dp[i] >= maxCount) {
                maxIndex = i;
                maxCount = dp[i];
            }
        }

        //从最大值开始向左移动，到某一位置的最大长度如果为上一场度-1，那么该值就可取，选择第一个遇到的（因为越右边越小）
        sb.append(arr[maxIndex]);
        for (int i = maxIndex - 1; i >= 0; i--) {
            //如果有多个dp[i]==dp[maxIndex]-1，最右边的一定是最小的
            if (dp[i] == dp[maxIndex] - 1) {
                sb.insert(0, arr[i] + " ");
                maxIndex = i;
            }
        }
        System.out.println(sb);
    }

    /**
     * O(n^2)的时间复杂度
     *
     * @param arr
     */
    private static void getDp1(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();


        int maxIndex = 0, maxCount = dp[0];
        //dp表示的是到i位置的最大值
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] >= maxCount) {
                maxIndex = i;
                maxCount = dp[i];
            }
        }

        //从最大值开始向左移动，到某一位置的最大长度如果为上一场度-1，那么该值就可取，选择第一个遇到的
        sb.append(arr[maxIndex]);
        for (int i = maxIndex - 1; i >= 0; i--) {
            //如果有多个dp[i]==dp[maxIndex]-1，最右边的一定是最小的
            if (dp[i] == dp[maxIndex] - 1) {
                sb.insert(0, arr[i] + " ");
                maxIndex = i;
            }
        }
        System.out.println(sb);
    }


}
