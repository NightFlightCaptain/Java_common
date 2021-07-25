package algorithm.realExam.NetEase2021Internship;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: 小栗旬
 * @Date: 2021/3/27 15:38
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(getMax(nums));
    }

    private static int getMax(int[] nums) {
        boolean[] exists = new boolean[1000000001];
        exists[0]=true;
        int curSum = 0;
        int maxRes =-1;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int curNum = nums[i];

            Set<Integer> set = new HashSet<>();
            for (int j = 0; j <= curSum; j++) {
                if (exists[j] && (!exists[j+curNum])){
                    set.add(j+curNum);

                }
            }
            for (Integer integer : set) {
                exists[integer] = true;
                if (((integer) %6)==0){
                    maxRes = Math.max(maxRes,integer);
                }
            }
            curSum += curNum;
        }
        return maxRes;
    }
}
