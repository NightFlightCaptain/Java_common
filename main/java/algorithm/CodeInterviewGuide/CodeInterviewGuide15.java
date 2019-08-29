package algorithm.CodeInterviewGuide;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/28 7:28
 * <p>
 * <p>
 * 题目描述
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置，求每一种窗口状态下的最大值。
 * （如果数组长度为n，窗口大小为w，则一共产生n-w+1个窗口的最大值）
 * <p>
 * 输入描述:
 * 第一行输入n和w，分别代表数组长度和窗口大小
 * 第二行输入n个整数X_i，表示数组中的各个元素
 * <p>
 * 输出描述:
 * 输出一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值
 * <p>
 * 示例1
 * 输入
 * 8 3
 * 4 3 5 4 3 3 6 7
 * 输出
 * 5 5 5 4 6 7
 * 说明
 * 例如，数组为[4，3，5，4，3，3，6，7]，窗口大小为3时：
 * <p>
 * [4 3 5] 4 3 3 6 7        窗口中最大值为5
 * <p>
 * 4 [3 5 4] 3 3 6 7        窗口中最大值为5
 * <p>
 * 4 3 [5 4 3] 3 6 7        窗口中最大值为5
 * <p>
 * 4 3 5 [4 3 3] 6 7        窗口中最大值为4
 * <p>
 * 4 3 5 4 [3 3 6] 7        窗口中最大值为6
 * <p>
 * 4 3 5 4 3 [3 6 7]        窗口中最大值为7
 * <p>
 * 输出的结果为{5 5 5 4 6 7}
 */
public class CodeInterviewGuide15 {
    /* 剑指Offer MaxInWindows
     核心想法就是 当我们往窗口中新增加一个数时，前面比这个数小的数都不会被用到了。 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] res = new int[n - w + 1];
        int resIndex = 0;
        //linkedlist中存放的是当前位置窗口的最大值
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //当我们在一个数组或者集合按照条件取其中一个值时，考虑某些值是不是不会被取到
            while (!linkedList.isEmpty() && nums[i] > linkedList.getLast()) {
                linkedList.pollLast();
            }
            if (i < w - 1) {
                while (linkedList.size() <=i) {
                    linkedList.add(nums[i]);
                }
            } else {
                while (linkedList.size() < w) {
                    linkedList.add(nums[i]);
                }
                res[resIndex++] = linkedList.removeFirst();
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int re : res) {
            stringBuilder.append(" ").append(re);
        }
        System.out.println(stringBuilder.substring(1));
    }
}
