package algorithm.realExam.iqiyi;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/8/1 14:50
 *
 * 5,6,8,26,50,48,52,55,10,1,2,1,20,5:3

 */
public class Iqiyi2021A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] ins = line.split(":");
        int k = Integer.valueOf(ins[1]);
        String[] numSs = ins[0].split(",");
        int[] nums = new int[numSs.length];
        for (int i = 0; i < numSs.length; i++) {
            nums[i] = Integer.valueOf(numSs[i]);

        }
        int curNum =0;
        int lastIndex =k;
        for (int i =0;i<k;i++){
            curNum+=nums[i];
        }
        double p =0;
        while (lastIndex<nums.length){
            int newNum = curNum+nums[lastIndex]-nums[lastIndex-k];
            double curP = ((double)newNum - curNum)/curNum;
            curNum = newNum;
            p = Math.max(curP,p);
            lastIndex++;
        }
        System.out.println(String.format("%.2f",p*100)+"%");
    }
}
