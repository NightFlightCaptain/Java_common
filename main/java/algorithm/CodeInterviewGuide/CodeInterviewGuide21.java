package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【计算数组的小和】
 * <p>
 * 题目描述
 * 数组小和的定义如下：
 * 例如，数组s = [1, 3, 5, 2, 4, 6]，在s[0]的左边小于或等于s[0]的数的和为0；在s[1]的左边小于或等于s[1]的数的和为1；
 * 在s[2]的左边小于或等于s[2]的数的和为1+3=4；在s[3]的左边小于或等于s[3]的数的和为1；
 * 在s[4]的左边小于或等于s[4]的数的和为1+3+2=6；在s[5]的左边小于或等于s[5]的数的和为1+3+5+2+4=15。所以s的小和为0+1+4+1+6+15=27
 * 给定一个数组s，实现函数返回s的小和
 * [要求]
 * 时间复杂度为O(nlogn)，空间复杂度为O(n)
 * <p>
 * 输入描述:
 * 第一行有一个整数N。表示数组长度
 * 接下来一行N个整数表示数组内的数
 * 输出描述:
 * 一个整数表示答案
 * 示例1
 * 输入
 * 6
 * 1 3 5 2 4 6
 * 输出
 * 27
 * <p>
 * 备注:
 * 1<=N<=10^5
 * -100<= arr_i<=100
 * ​
 *
 * @author: 小栗旬
 * @Date: 2019/8/30 13:57
 */
public class CodeInterviewGuide21 {
    //使用一种归并排序的思想
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(getFunc(nums, 0, n-1));
    }

    private static long getFunc(int[] nums, int left, int right) {
        if (left==right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        return getFunc(nums,left,mid)+getFunc(nums,mid+1,right)+merge(nums,left,mid,right);
    }

    private static long merge(int[] nums, int left, int mid, int right) {
        int[] h = new int[right - left + 1];
        int hi = 0;
        int i = left, j = mid + 1;
        //如果为int则无法通过
        long total = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                total += (right - j + 1) * nums[i];
                h[hi++] = nums[i++];
            } else {
                h[hi++] = nums[j++];
            }
        }
        while (i <= mid ) {
            h[hi++] = nums[i++];
        }
        while (j<=right){
            h[hi++] = nums[j++];

        }
        for (int k = 0; k <= right-left; k++) {
            nums[left+k] = h[k];
        }
        return total;

    }
}
