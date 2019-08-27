package algorithm.CodeInterviewGuide;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/27 14:18
 * <p>
 * 题目描述
 * 给定一个无序数组arr，其中元素只能是1或0。求arr所有的子数组中0和1个数相等的最长子数组的长度
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(n)
 * <p>
 * 输入描述:
 * 第一行一个整数N，表示数组长度
 * 接下来一行有N个数表示数组中的数
 * <p>
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 5
 * 1 0 1 0 1
 * 输出
 * 4
 */
public class CodeInterviewGuide11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>(N);
        map.put(0,-1);
        int totalCount = 0;
        int currentCount = 0;
        for (int i = 0; i < N; i++) {
            currentCount += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(currentCount)){
                totalCount = Math.max(totalCount,i-map.get(currentCount));
            }else {
                map.put(currentCount,i);
            }
        }
        System.out.println(totalCount);
    }

}
