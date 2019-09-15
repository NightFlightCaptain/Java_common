package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【数学计算】【不包含本位置值的累乘数组】
 * <p>
 * 题目描述
 * 给定一个数组arr，返回不包含本位置值的累乘数组
 * 例如，arr=[2,3,1,4]，返回[12, 8, 24, 6]，即除自己外，其他位置上的累乘
 * [要求]
 * 时间复杂度为O(n)，额外空间复杂度为O(1)
 * <p>
 * 输入描述:
 * 第一行有两个整数N, P。分别表示序列长度，模数(即输出的每个数需要对此取模)
 * 接下来一行N个整数表示数组内的数
 * 输出描述:
 * 输出N个整数表示答案
 * 示例1
 * 输入
 * 4 100000007
 * 2 3 1 4
 * 输出
 * 12 8 24 6
 * 备注:
 * 1<=N<=10^5
 * 1<=P<=10^9+7
 * 1<=arr_i<=10^9
 *
 * @author: 小栗旬
 * @Date: 2019/9/15 14:23
 */
public class CodeInterviewGuide35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        //res是结果数组，不属于额外空间【？书上是这么解释的】
        long[] res = new long[n];
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = (res[i - 1] * nums[i])%p;
        }
        long product = 1;
        for (int i = n - 1; i >= 1; i--) {
            res[i] = (res[i - 1] * product)%p;
            product=(product*nums[i])%p;
        }
        res[0]=product;
        StringBuilder stringBuilder = new StringBuilder();
        for (long resNum:res){
            stringBuilder.append(" ").append(resNum);
        }
        System.out.println(stringBuilder.substring(1));
    }
}
