package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【二分查找】 【在数组中找到一个局部最小的位置】
 * <p>
 * 题目描述
 * 定义局部最小的概念。arr长度为1时，arr[0]是局部最小。arr的长度为N(N>1)时，如果arr[0]<arr[1]，那么arr[0]是局部最小；
 * 如果arr[N-1]<arr[N-2]，那么arr[N-1]是局部最小；如果0<i<N-1，既有arr[i]<arr[i-1]，又有arr[i]<arr[i+1]，那么arr[i]是局部最小。
 * 给定无序数组arr，已知arr中任意两个相邻的数不相等。写一个函数，只需返回arr中任意一个局部最小出现的位置即可
 * [要求]
 * 时间复杂度为O(logn)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行有一个整数N。表示数组长度
 * 接下来一行，N个整数表示数组中的数
 * 输出描述:
 * 输出一个整数表示答案
 * 示例1
 * 输入
 * 3
 * 2 1 3
 * 输出
 * 1
 * 说明
 * 因为arr[0] > arr[1] 且 arr[1] < arr[2]，因此1是一个合法答案
 * 示例2
 * 输入
 * 1
 * 1
 * 输出
 * 0
 * 备注:
 * 2<=N<=10^5
 * −10^9<=arr_i<=10^9
 *
 * @author: 小栗旬
 * @Date: 2019/9/6 21:34
 */
public class CodeInterviewGuide28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        if (nums[0] < nums[1]) {
            System.out.println(0);
            return;
        }
        if (nums[n - 1] < nums[n - 2]) {
            System.out.println(n - 1);
            return;
        }
        int left = 0, right = n - 1;
        int mid;
        while (left<=right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid - 1]) {
                right = mid - 1;
            } else if (nums[mid] > nums[mid + 1]) {
                left = mid + 1;
            } else {
                System.out.println(mid);
                return;
            }
        }

    }
}
