package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/11 9:33
 * <p>
 * 【未排序正数数组中累加和为给定值的最长子数组的长度】
 * <p>
 * 题目描述
 * 给定一个数组arr，该数组无序，但每个值均为正数，再给定一个正数k。求arr的所有子数组中所有元素相加和为k的最长子数组的长度
 * 例如，arr = [1, 2, 1, 1, 1], k = 3
 * 累加和为3的最长子数组为[1, 1, 1]，所以结果返回3
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行两个整数N, k。N表示数组长度，k的定义已在题目描述中给出
 * 第二行N个整数表示数组内的数
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 5 3
 * 1 2 1 1 1
 * <p>
 * 输出
 * 3
 */
public class CodeInterviewGuide8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        final int k = scanner.nextInt();
        if (N == 0) {
            return;
        }
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }

        int num = nums[0], left = 0, right = 0;
        int maxCount = Integer.MIN_VALUE;

        //1.O(2n)也是O(n),与子数组问题相关的时候应该考虑能不能使用两个指针代表子数组的左右两端
        //2.考虑大多情况下和特殊情况下，将特殊情况提出使用if来判断这种特殊情况
        while (right < N) {
            if (num == k) {
                maxCount = Math.max(maxCount, right - left + 1);
                num -= nums[left++];
            } else if (num < k) {
                right++;
                if (right == N){
                    break;
                }
                num += nums[right];
            } else {
                num -= nums[left++];
            }

        }
        System.out.println(maxCount);
    }
}
