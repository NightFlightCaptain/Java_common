package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【排序	】【数组的partition调整】
 * <p>
 * 题目描述
 * 给定一个有序数组arr，调整arr使得这个数组的左半部分[1, (n+1)/2]没有重复元素且升序，而不用保证右部分是否有序
 * 例如，arr = [1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9]，调整之后arr=[1, 2, 3, 4, 5, 6, 7, 8, 9, .....]。
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行一个整数N。表示数组长度。
 * 接下来一行N个整数，表示数组内元素
 * 输出描述:
 * 输出N个整数为答案数组
 * 示例1
 * 输入
 * 16
 * 1 2 2 2 3 3 4 5 6 6 7 7 8 8 8 9
 * 输出
 * 1 2 3 4 5 6 7 8 9 6 2 7 2 8 8 3
 * 示例2
 * 输入
 * 5
 * 2 3 4 4 5
 * 输出
 * 2 3 4 5 4
 * 备注:
 * 1<=N<=10^5
 * 1<=arr_i<=10^9
 * <p>
 * 本题有special judge，对于右边的部分，你可以任意输出(在保证合法的前提下)
 *
 * @author: 小栗旬
 * @Date: 2019/9/15 15:49
 */
public class CodeInterviewGuide36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //index代表到从0到index所有的位置都是符合要求的
        //只需要关注index位置的值
        int index =0;
        for (int i = 1; i < n; i++) {
            if (nums[index] != nums[i]){
                swap(nums,index+1,i);
                index++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(nums).forEachOrdered(o -> stringBuilder.append(" ").append(o));
        System.out.println(stringBuilder.substring(1));
    }

    private static void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
