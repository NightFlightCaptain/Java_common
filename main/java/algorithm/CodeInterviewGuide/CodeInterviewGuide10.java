package algorithm.CodeInterviewGuide;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/27 11:24
 * <p>
 * 题目描述
 * 给定一个无序数组arr，其中元素可正、可负、可0。求arr所有子数组中正数与负数个数相等的最长子数组的长度。
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(n)
 * <p>
 * 输入描述:
 * 第一行一个整数N，表示数组长度
 * 接下来一行有N个数表示数组中的数
 * <p>
 * 输出描述:
 * 输出一个整数表示答案
 * <p>
 * 示例1
 * 输入
 * 5
 * 1 -2 1 1 1
 * 输出
 * 2
 */
public class CodeInterviewGuide10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int current =0;
        int maxCount =0;
        for (int i = 0; i < N; i++) {
            current +=Integer.compare(nums[i],0);
            if (map.containsKey(current)){
                maxCount = Math.max(maxCount,i-map.get(current));
            }else {
                map.put(current,i);
            }
        }
        System.out.println(maxCount);

    }
}
