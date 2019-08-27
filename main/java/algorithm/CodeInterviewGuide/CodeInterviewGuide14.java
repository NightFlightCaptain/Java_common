package algorithm.CodeInterviewGuide;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/27 15:52
 * <p>
 * 题目描述
 * 给定一个无序数组arr，其中元素可正、可负、可0。给定一个整数k，求arr所有的子数组中累加和小于或等于k的最长子数组长度
 * 例如：arr = [3, -2, -4, 0, 6], k = -2. 相加和小于等于-2的最长子数组为{3, -2, -4, 0}，所以结果返回4
 * <p>
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(n)
 * <p>
 * 输入描述:
 * 第一行两个整数N, k。N表示数组长度，k的定义已在题目描述中给出
 * 第二行N个整数表示数组内的数
 * <p>
 * 输出描述:
 * 输出一个整数表示答案
 * <p>
 * 示例1
 * 输入
 * 5 -2
 * 3 -2 -4 0 6
 * 输出
 * 4
 */
public class CodeInterviewGuide14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(nums[0]);
            return;
        }
        //以每一个点位最左点往右的最小和
        int[] help = new int[n];
        help[n - 1] = nums[n - 1];
        //以每一个点位最左点往右的最小和的最右点的坐标
        HashMap<Integer, Integer> map = new HashMap<>(n);
        map.put(n - 1, n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (help[i + 1] <= 0) {
                help[i] = help[i + 1] + nums[i];
                map.put(i, map.get(i + 1));
            } else {
                help[i] = nums[i];
                map.put(i, i);
            }
        }

        int totalCount = 0;
        int totalSum = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = i+1;
            totalSum=0;
            //不断往右取，直到不符合条件
            while (end < n && totalSum + help[end] <= k) {
                totalSum += help[end];
                end = map.get(end) + 1;
            }
            totalCount = Math.max(totalCount, end - i);
        }
        System.out.println(totalCount);
    }
}
