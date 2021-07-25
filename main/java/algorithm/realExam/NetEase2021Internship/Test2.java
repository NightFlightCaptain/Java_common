package algorithm.realExam.NetEase2021Internship;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/3/27 15:14
 */

/**
 * 6
 * -1 2 1 0 1 0
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(getYBArray(nums));
    }

    private static int getYBArray(int[] nums) {
        boolean hasMaxThan2 = false;
        int length = nums.length;
        int[] changeCounts = new int[length];
        int[] changeLength = new int[length];

        for (int i = 1; i < length; i++) {
            int result = compare(nums[i - 1], nums[i]);
            if (result == 0) {
                changeCounts[i] = 0;
            } else if (result > 0) {
                changeCounts[i] = 1;

            } else {
                changeCounts[i] = -1;
            }
        }
        int changeCount =0;
        for (int i = 1; i < length; i++) {
            if (changeCounts[i]==0){

            }
            if (changeCounts[i] * changeCounts[i-1] >0){
                changeCount++;
            }else {
                changeCount =1;
            }
        }
        return 1;
    }

    private static int compare(int num1, int num2) {
        return num1 - num2;
    }
}
