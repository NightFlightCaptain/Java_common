package algorithm.realExam.ByteDance2019Spring;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/1 16:44
 */
public class ByteDance2019Spring2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        if (n <= 2) {
            System.out.println(0);
            return;
        }

        int index = 0;
        long sum = 0;
        for (int i = 2; i < n; i++) {
            while (nums[i] - nums[index] > d) {
                index++;
            }
            sum += getCount(i - index);
        }
        sum%=99997867;
        System.out.println(sum);
    }

    //这个地方的传入参数必须是long类型！！！
    private static long getCount(long m) {
        return m * (m - 1) / 2;
    }
}
