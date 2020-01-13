package algorithm.realExam.PDD2018;

import java.util.Scanner;

/**
 * 【数三角形】
 * <p>
 * 给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 第一行包含一个正整数n，表示平面上有n个点（n <= 100)
 * 第2行到第n + 1行，每行有两个整数，表示这个点的x坐标和y坐标。(所有坐标的绝对值小于等于100，且保证所有坐标不同）
 * <p>
 * 输出描述:
 * 输出一个数，表示能构成三角形的方案数。
 * <p>
 * 输入例子1:
 * 4
 * 0 0
 * 0 1
 * 1 0
 * 1 1
 * <p>
 * 输出例子1:
 * 4
 * <p>
 * 例子说明1:
 * 4个点中任意选择3个都能构成三角形
 *
 * @author: 小栗旬
 * @Date: 2019/10/31 12:46
 */
public class PDD2018C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }

        int res =0;
        for (int i =0;i<n;i++){
            for (int j =i+1;j<n;j++){
                for (int k =j+1;k<n;k++){
                    if (isTriangle(points[i],points[j],points[k])){
                        res++;
                    }
                }
            }
        }
        System.out.println(res);


    }

    private static boolean isTriangle(Point point1, Point point2, Point point3) {
        if (point1.y == point2.y && point1.y == point3.y) {
            return false;
        }
        if (point1.y == point2.y||point1.y==point3.y||point2.y==point3.y){
            return true;
        }
        // 斜率是否一致
        boolean isSlopeSame = ((double)(point1.x - point2.x) / (point1.y - point2.y) == (double)(point1.x - point3.x) / (point1.y - point3.y));
        if (!isSlopeSame) {
            return true;
        }
        return false;
    }

}

class Point {
    int x;
    int y;
    boolean used;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
