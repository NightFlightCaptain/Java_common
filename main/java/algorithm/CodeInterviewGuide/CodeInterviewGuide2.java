package algorithm.CodeInterviewGuide;

import java.util.HashSet;
import java.util.Scanner;

/**
 * author: 小栗旬
 * Date: 2019/8/4 9:03
 *
 * <p>
 * 题目描述
 * 先给出可整合数组的定义：如果一个数组在排序之后，每相邻两个数的差的绝对值都为1，或者该数组长度为1，则该数组为可整合数组。
 * 例如，[5, 3, 4, 6, 2]排序后为[2, 3, 4, 5, 6]，符合每相邻两个数差的绝对值都为1，所以这个数组为可整合数组
 * 给定一个数组arr, 请返回其中最大可整合子数组的长度。例如，[5, 5, 3, 2, 6, 4, 3]的最大可整合子数组为[5, 3, 2, 6, 4]，所以请返回5
 * [要求]
 * 时间复杂度为O(n^2)
 * 空间复杂度为O(n)
 * 输入描述:
 * 第一行一个整数N，表示数组长度
 * 第二行N个整数，分别表示数组内的元素
 * 输出描述:
 * 输出一个整数，表示最大可整合子数组的长度
 * <p>
 * 示例1
 * 输入
 * 7
 * 5 5 3 2 6 4 3
 * 输出
 * 5
 * 说明
 * 备注:
 * 1⩽N⩽5000
 * 0⩽数组中的元素⩽10^9
 *
 */
public class CodeInterviewGuide2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 1;
        for (int i = 0; i < N; i++) {
            //剩下的数组所最大可整合已不可能超过现在的数组，则直接跳出
            if (maxCount >= N - i + 1) {
                break;
            }
            int max = arr[i], min = arr[i];
            set.add(arr[i]);
            for (int j = i + 1; j < N; j++) {
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                if (arr[j] > max) {
                    max = arr[j];
                }
                if (arr[j] < min) {
                    min = arr[j];
                }
                //如果当前数组没有重复，而且最大值减去最小值等于数组长度-1，那么当前数据就是可整合数组
                if (max - min == j - i) {
                    maxCount = max - min + 1 > maxCount ? max - min + 1 : maxCount;
                }
            }
            set.clear();
        }
        System.out.println(maxCount);
    }
}
