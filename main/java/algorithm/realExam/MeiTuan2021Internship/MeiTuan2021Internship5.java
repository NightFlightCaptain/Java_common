package algorithm.realExam.MeiTuan2021Internship;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/4/4 11:49
 * <p>
 * <p>
 * 小美的糖果
 * 时间限制： 3000MS
 * 内存限制： 1048576KB
 * 题目描述：
 * 小团和小美分别从家里拿了A颗糖果和B颗糖果。每一颗糖果都有一个甜度，不同糖果的甜度可能相同，并且有些糖果味道可能很差，其甜度为零甚至是负值。小美和小团一起把这些糖果分给幼儿园的小朋友，但是有个规则：对于两个人手上的糖果只能按顺序一个一个地拿，即将两个人手上的糖果每个人分别标记为1，2，3…，在拿走某一个人的第i颗糖果之前的所有i-1颗糖果都必须全部拿走。
 * <p>
 * 小朋友们可以任意选择拿的数目，甚至可以一颗也不拿，他们能够获得的甜度总和的最大值为多少？
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 第一行A，B两个整数；
 * <p>
 * 第二行A个整数a1,a2,a3,...,aA，表示小团手上第i颗糖果的甜度；
 * <p>
 * 第三行B个整数b1,b2,b3,...,bB，表示小美手上第i颗糖果的甜度。
 * <p>
 * 1<=A+B<=200000, -100<=ai,bi<=100。
 * <p>
 * 输出描述
 * 输出仅包含一个非负整数，表示能够获得的甜度之和的最大值，例如当糖果都为负数的时候，答案为0。
 * <p>
 * <p>
 * 样例输入
 * 3 4
 * 1 -1 0
 * 2 2 -5 3
 * 样例输出
 * 5
 * <p>
 * 提示
 * 拿走小团的第一颗糖果和小美的前两颗糖果，甜度之和最大。如果要拿走小美的第四颗糖果，那么小美手上前面三颗都要全部拿走，拿走小团的第一颗糖果，此时甜度之和为3，并不是最优解。
 */
public class MeiTuan2021Internship5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int[] nums1 = new int[A];
        int[] nums2 = new int[B];
        for (int i = 0; i < A; i++) {
            nums1[i] = scanner.nextInt();
        }
        for (int i = 0; i < B; i++) {
            nums2[i] = scanner.nextInt();
        }
        System.out.println(get(nums1) + get(nums2));
    }

    private static  int get(int[] nums){
        int res =0;
        int cur =0;
        int len = nums.length;
        for (int i =0;i<len;i++){
            cur += nums[i];
            res = Math.max(res,cur);
        }
        return res;
    }
}
