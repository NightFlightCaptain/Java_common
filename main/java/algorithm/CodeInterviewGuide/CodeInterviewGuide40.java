package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【桶排	】【数组排序之后相邻数的最大差值】
 * <p>
 * 题目描述
 * 给定一个整形数组arr，返回排序后相邻两数的最大差值
 * arr = [9, 3, 1, 10]。如果排序，结果为[1, 3, 9, 10]，9和3的差为最大差值，故返回6。
 * arr = [5, 5, 5, 5]。返回0。
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(n)
 * <p>
 * 输入描述:
 * 第一行一个整数N。表示数组长度。
 * 接下来N个整数表示数组内的元素
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 4
 * 9 3 1 10
 * 输出
 * 6
 * <p>
 * 示例2
 * 输入
 * 4
 * 5 5 5 5
 * 输出
 * 0
 * 备注:
 * 1<=N<=10^6
 * 1<=arr_i<=10^9
 *
 * @author: 小栗旬
 * @Date: 2019/9/21 12:27
 */
public class CodeInterviewGuide40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //将n个数分到n+1个桶中间去，并且最小数放到第一个桶，最大数放到最后一个桶
        // 中间必然最少有一个桶是空的，隔着一个空桶的间隔一个比一个桶内的间隔要大
        int[] maxBucket = new int[n + 1];
        int[] minBucket = new int[n + 1];
        Arrays.fill(maxBucket, Integer.MIN_VALUE);
        Arrays.fill(minBucket, Integer.MAX_VALUE);
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            maxNum = Math.max(nums[i], maxNum);
            minNum = Math.min(nums[i], minNum);
        }
        //每个桶的区间长度，有余数则+1
        int bucketLength = (maxNum - minNum + 1) % (n + 1) == 0 ? (maxNum - minNum + 1) / (n + 1) : (maxNum - minNum + 1) / (n + 1) + 1;
        //求出每个桶区间的最大值和最小值。
        for (int i = 0; i < n; i++) {
            int bucketIndex = (nums[i] - minNum) / bucketLength;
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], nums[i]);
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], nums[i]);
        }
        int res = 0;
        int lastMax = maxBucket[0];
        for (int i = 1; i < n + 1; i++) {
            if (maxBucket[i] != Integer.MIN_VALUE) {
                res = Math.max(res,minBucket[i]-lastMax);
                lastMax = maxBucket[i];
            }
        }
        System.out.println(res);
    }
}
