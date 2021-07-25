package algorithm.realExam.NetEase2021Internship;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/3/27 15:02
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numsString = line.split(",");
        int length = numsString.length;
        Integer[] nums = new Integer[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                nums[0] = Integer.valueOf(numsString[0].substring(1));
            } else if (i == length - 1) {
                nums[length - 1] = Integer.valueOf(numsString[i].substring(0, numsString[i].length() - 1));
            }else {
                if (numsString[i] == "null"){
                    nums[i]=0;
                }else {
                    nums[i] = Integer.valueOf(numsString[i]);
                }
            }

        }
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(nums));
    }

    private static void get(int[] nums, int target, int headIndex, List<Integer> list){
        if (target ==0){
            return;
        }
        if (target >=nums[headIndex]){
            list.add(nums[headIndex]);
            get(nums,target-nums[headIndex],headIndex*2+1,list);
        }

    }

}
