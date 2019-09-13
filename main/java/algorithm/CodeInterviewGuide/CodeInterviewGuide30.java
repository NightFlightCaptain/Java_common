package algorithm.CodeInterviewGuide;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【动态规划】	【汉诺塔问题】
 * <p>
 * 题目描述
 * 给定一个整数n，代表汉诺塔游戏中从小到大放置n个圆盘，假设开始所有圆盘都在左边的柱子上，
 * 那么用最优的办法把所有圆盘都移动到右边的柱子上的过程，就称为最优移动轨迹。
 * 给定一个整型数组arr, 其中只含有1、2和3,代表所有圆盘目前的状态，1代表左柱，2代表中柱，3代表右柱，
 * a[i]的值代表第i+1个圆盘的位置（a[i]下标从0开始）。比如，arr=[3,3,2,1],
 * 代表第1个圆盘在右柱上、第2个圆盘在右柱上、第3个圆盘在中柱上、第4个圆盘在左柱上。
 * 如果arr代表的状态是最优移动轨迹过程中出现的状态，输出arr这种状态是最优移动轨迹中的第几个状态（由于答案可能较大，请输出对10^9+7取模后的答案）。
 * 如果arr代表的状态不是最优移动轨迹过程中出现的状态，则输出-1。
 * <p>
 * 输入描述:
 * 输入包括两行，第一行一个整数(1<=n<=2∗10^6)，表示圆盘的个数，第二行n个正整数，且均为1或2或3，第i个整数表示第i个圆盘位置。
 * 输出描述:
 * 输出一个整数，表示这种状态是第几个最优移动状态（输出对10^9+7取模后的答案），无解输出-1。
 * 示例1
 * 输入
 * 2
 * 1 1
 * 输出
 * 0
 * <p>
 * 示例2
 * 输入
 * 2
 * 3 3
 * 输出
 * 3
 * <p>
 * 备注:
 * 时间复杂度O(n)，空间复杂度O(n)。
 *
 * @author: 小栗旬
 * @Date: 2019/9/13 14:07
 */
public class CodeInterviewGuide30 {
    static int[] target;
    static int[] pows;

    /*
    一个汉诺塔有n个圆环，将其从A塔上面移动到C塔上面（有辅助B塔），最有路径需要操作2^n-1次
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        n=200000;
        nums = new int[n];
        Arrays.fill(nums,3);
        pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; i++) {
            pows[i] = (pows[i - 1] << 1) % 1000000007;
        }
        //目标的状态
        target = nums;

        int res = 0;
        int count = n - 1;
        int from = 1, other = 2, to = 3;
        while (count >= 0) {
            if (target[count] == other) {
                System.out.println(-1);
                return;
            }
            //count是每次递归都减一
            //说明该列不用移动
            if (target[count] == from) {
                int temp = to;
                to = other;
                other = temp;
            } else {
                //说明该列需要移动，那么就是需要移动前count-1列，需要操作2^count-1次，然后count列需要移动一次
                res += pows[count];
                res%=1000000007;
                //count列搞定之后，再考虑count-1列的情况，依此类推
                int temp = from;
                from = other;
                other = temp;
            }
            count--;
        }
        System.out.println(res);
    }

    /*
    采用递归方法会stackoverflowerror
     */
//    private static long fromTo(int count, int from, int other, int to) {
//
//        if (count == -1) {
//            return 0;
//        }
//        if (target[count] == other) {
//            return -1;
//        }
//        //count是每次递归都减一
//        //说明该列不用移动
//        if (target[count] == from) {
//            return fromTo(count - 1, from, to, other);
//        } else {
//            //说明该列需要移动，那么就是需要移动前count-1列，需要操作2^count-1次，然后count列需要移动一次
//            long res = pows[count];
//            //count列搞定之后，再考虑count-1列的情况，依此类推
//            long rest = fromTo(count - 1, other, from, to) ;
//            if (rest == -1) {
//                return -1;
//            }
//            return (res + rest) % 1000000007;
//        }
//
//    }
}
