package algorithm.realExam.YFD2021;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/7/31 18:55
 */
public class YFD2021A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        int[] nums = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.valueOf(strings[i]);
        }
        int indexMin = 0;
        int indexMax = 0;
        boolean hasChanged = false;
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!hasChanged){
                if (nums[i] > nums[i + 1]) {

                    indexMin = i+1;
                    min = nums[i];
                    hasChanged = true;

                }
            }else {
                if (nums[i]<min){
                    indexMax = i+1;
                }
            }

        }
        if (indexMax ==0){
            indexMax = nums.length;
        }
        System.out.println(indexMin + " " + indexMax);
    }
}
