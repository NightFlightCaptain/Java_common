package algorithm.CodeInterviewGuide;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 【未排序数组中累加和为给定值的最长子数组长度】
 * <p>
 * 题目描述
 * 给定一个无序数组arr, 其中元素可正、可负、可0。给定一个整数k，求arr所有子数组中累加和为k的最长子数组长度
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
 * 5 0
 * 1 -2 1 1 1
 * <p>
 * 输出
 * 3
 *
 * @author: 小栗旬
 * @Date: 2019/8/12 20:29
 */

public class CodeInterviewGuide9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int k = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        /*map结构，key表示的求得的和，value表示的是从最左边到第i个数的和恰好为key的最小的i值

         逻辑在于：从第一个点到第i个点的和 减去 从第一个点到第j个点的和 的差值 刚好等于target，
         那么从第i+1到j的和就刚好是target。这也是为什么value中存的i是最小的

         {思考：一般来说，我们都会在map的key里面存条件，value存结果，但有时可以假设我们已经知道了结果，就将结果存在key，
         将条件存放在value中}
        */
        HashMap<Integer, Integer> map = new HashMap<>(N);
        int maxCount = Integer.MIN_VALUE;
        int current = 0;
        //(0,-1)表示的从第1位到当前位的长度
        map.put(0,-1);
        for (int i = 0; i < N; i++) {
            current += nums[i];
            if (!map.containsKey(current)) {
                map.put(current, i);
            }
            Integer r = map.get(current-k);
            if (r!=null){
                maxCount = Math.max(maxCount,i-r);
            }
        }
        System.out.println(maxCount);
    }
}
