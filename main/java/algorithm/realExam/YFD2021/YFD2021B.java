package algorithm.realExam.YFD2021;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2021/7/31 18:55
 */
public class YFD2021B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = s.length();
        int boxType = 0;
        int curBox = 0;
        int sumBox = 0;
        LinkedList<Integer> dep = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                boxType += 1;
                dep.add(0);
            } else if (c == ']') {
                int boxNum;
                if (i >= len-1 ) {
                    boxNum = 1;
                } else {
                    if (s.charAt(i + 1) == '[' || s.charAt(i+1)==']') {
                        boxNum = 1;
                    } else {
                        boxNum = Integer.valueOf(String.valueOf(s.charAt(i + 1)));
                    }
                }
                curBox =(curBox+1) * boxNum;
                sumBox += curBox;
                boxType -= 1;
                if (boxType==0){
                    curBox=0;
                }

            }
        }
        System.out.println(sumBox);
    }
}
