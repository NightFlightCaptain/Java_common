package algorithm.realExam.MeiTuan2021Internship;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/4/4 9:47
 * <p>
 * 第一行一个正整数n，表示切了n刀
 * <p>
 * 接下来n行，每行两个整数t,x，如果t=0，那么x表示小美选择横着切的纬度；如果t=1，那么x表示小美选择竖着切的经度。
 * <p>
 * 数据保证：
 * <p>
 * （1）经度的取值范围为[0,360)，纬度的取值范围为(0,360)；
 * <p>
 * （2）所有选择的经度和纬度各自均不会重复；
 * <p>
 * 1≤n≤700,t∈{0,1},x∈[0,360)（此数据没有t=0,x=0的情况）
 */
public class MeiTuan2021Internship2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] index= new int[2][361];
        int res=1;
        for (int i = 0; i < n; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            res *=2;
        }
        System.out.println(res);

    }




}
