package algorithm.realExam.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2020/3/19 19:00
 */
public class MeiTuan2020Spring1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n<=3){
            System.out.println(0);
        }
        long[] nums1 = new long[n];
        long[] nums2 = new long[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = scanner.nextLong();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextLong();
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        long sum1 = nums1[n-1]+nums1[n-2]+nums1[n-3];
        long sum2 = nums2[n-1]+nums2[n-2]+nums2[n-3];
        System.out.println(Math.max(sum1, sum2));

    }
}
