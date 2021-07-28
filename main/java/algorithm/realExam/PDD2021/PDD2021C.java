package algorithm.realExam.PDD2021;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/7/25 18:52
 * <p>
 * <p>
 * 3
 * 1 2 3 5
 * 2 3 2 10
 * 3 3 3 7
 */
public class PDD2021C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int q = scanner.nextInt();
            boolean[] isExist = new boolean[q + 1];
//            judge(isExist, a, b, c, q);
        }
    }
//
//    private static boolean judge(boolean[] isExist, int a, int b, int c, int q) {
//        if (q == a || q == b || q == c) {
//            return true;
//        }
//
//
//    }
//
//    private static boolean judge(boolean[] isExist, int a, int b, int q) {
//        if (q == a || q == b) {
//            return true;
//        }
//        judge(isExist, a, q - b);
//        if ((double) q / b == q / b) {
//            judge(isExist, a, q / b);
//        }
//        judge(isExist, b, q - a);
//
//        if ((double) q / a == q / a) {
//            judge(isExist, b, q / a);
//        }
//
//
//    }

    private static boolean judge(boolean[] isExist, int a, int q) {
        if (a <= q) {
            isExist[a] = true;
        }
        if (q == a) {
            return true;
        }
        return false;
    }

//    private static void judge(List<Integer> list,int q){
//        if (list.size() == 0){
//            return;
//        }else if (list.size() == 1){
//            if (list.get(0)==q){
//                System.out.println(1);
//            }
//            return;
//        }else if (list.size() ==2){
//
//        }
//    }

//    private static  void judge(int a,int b,int c,int q){
//        int[] nums = new int[q+1];
//        nums[0]=1;
//        tt(nums,a,q);
//        tt(nums,b,q);
//        tt(nums,c,q);
//
//        tt(nums,a+b,q);
//        tt(nums,a+c,q);
//        tt(nums,b+c,q);
//        tt(nums,a*b,q);
//        tt(nums,a*c,q);
//        tt(nums,b*c,q);
//
//        tt(nums,a+b+c,q);
//        tt(nums,(a+b)*c,q);
//        tt(nums,(a+c)*b,q);
//        tt(nums,(b+c)*a,q);
//
//        tt(nums,(a*b)+c,q);
//        tt(nums,(a*c)+b,q);
//        tt(nums,(b*c)+a,q);
//
//        tt(nums,(b*c)*a,q);
//        if (nums[q]==1){
//            System.out.println(1);
//        }else {
//            System.out.println(0);
//        }
//    }
//
//    private static void tt(int[] nums,int num,int q){
//        if (num<=q){
//            nums[num]=1;
//        }
//
//    }
}
