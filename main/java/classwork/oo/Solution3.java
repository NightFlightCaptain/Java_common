package classwork.oo;

import java.util.Arrays;

/**
 * @author: 小栗旬
 * @Date: 2019/10/19 10:37
 */
public class Solution3 {
    static int[][] points = new int[5][5];
    static int totalCount = 0;
    static int startX = 1;
    static int startY = 1;

    public static void main(String[] args) {
        int[][] rules = new int[][]{
                {3, 0}, {-3, 0}, {0, 3}, {0, -3}, {2, 2}, {2, -2}, {-2, 2}, {-2, -2}
        };
        Point start = new Point(startX, startY);
        points[startX-1][startY-1] = 1;

        move(rules, start,2);
        System.out.println(totalCount);
    }

    private static void printSingleResult() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(points[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void move(int[][] rules, Point loc, int count) {
        if (count == 26){
            printSingleResult();
            totalCount++;
        }
        for (int i = 0; i < rules.length; i++) {
            Point point = loc.add(rules[i]);
            if (point != null) {
                if (point.addToPoints(points,count)) {
                    move(rules, point, count+1);
                    point.removeFromPoints(points);
                }
            }
        }
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point add(int[] rule) {
        try {

            int tempX = x + rule[1];
            int tempY = y + rule[0];
            if (tempX < 1 || tempX > 5 || tempY < 1 || tempY > 5) {
                return null;
            }
            return new Point(tempX, tempY);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("x=" + x + " y=" + y);
            System.out.println(Arrays.toString(rule));
        }
        return null;
    }


    public boolean addToPoints(int[][] points,int count) {
        if (points[x - 1][y - 1] == 0) {
            points[x - 1][y - 1] = count;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeFromPoints(int[][] points) {
        if (points[x - 1][y - 1] == 0) {
            return false;
        }
        points[x - 1][y - 1] = 0;
        return true;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}