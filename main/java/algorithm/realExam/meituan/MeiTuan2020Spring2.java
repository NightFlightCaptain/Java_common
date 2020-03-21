package algorithm.realExam.meituan;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2020/3/19 19:12
 */
public class MeiTuan2020Spring2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] lens = new int[n];
        lens[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                lens[i] = lens[i - 1] + 1;
            } else {
                lens[i] = 1;
            }
        }

        int[] afterDel = new int[n];
        afterDel[1] = 0;
        int res = 1;
        for (int i = 1; i < n; i++) {
            int tem1 = 0, tem2 = 0;
            if (nums[i] > nums[i - 1]) {
                tem1 = afterDel[i - 1] + 1;
            }

            if (i >= 2 && nums[i] > nums[i - 2]) {
                tem2 = lens[i - 2] + 1;
            }
            afterDel[i] = Math.max(tem1, tem2);
            res = Math.max(res, afterDel[i]);
        }
        System.out.println(res);

    }
}
