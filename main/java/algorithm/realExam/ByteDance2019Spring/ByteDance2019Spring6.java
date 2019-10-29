package algorithm.realExam.ByteDance2019Spring;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/1 18:00
 */
public class ByteDance2019Spring6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getBalance(1024 - n));
    }

    private static int getBalance(int n) {
        int count =0;
        count += n/64;
        n = n%64;
        count += n/16;
        n = n%16;
        count += n/4;
        n = n%4;
        count+=n;
        return count;
    }
}
