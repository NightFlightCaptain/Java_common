package algorithm.realExam.PDD2021;

import java.util.*;

/**
 * @author: 小栗旬
 * @Date: 2021/7/25 18:52
 */
public class PDD2021B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> left = new LinkedList<>();
        LinkedList<Integer> right = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            left.add(scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            right.add(scanner.nextInt());
        }

        boolean isLeft = true;
        int leftWin = 0;
        int rightWin = 0;
        while (!left.isEmpty() || !right.isEmpty()) {
            if (isLeft) {
                if (left.isEmpty()) {
                    isLeft = false;
                    continue;
                }
                int card = left.poll();
                int count = count(card);
                if (count == 0) {
                    isLeft = false;
                } else {
                    leftWin += count;
                }
            } else {
                if (right.isEmpty()) {
                    isLeft = true;
                    continue;
                }
                int card = right.poll();
                int count = count(card);
                if (count == 0) {
                    isLeft = true;
                } else {
                    rightWin += count;
                }
            }
        }
        for (int i = 1; i <= 13; i++) {
            if (index[i] != 0) {
                if ((i % 2) == 0) {
                    rightWin++;
                } else {
                    leftWin++;
                }
            }
        }
        System.out.println(leftWin+" "+rightWin);
    }

    static int indexSize = 0;
    static int[] index = new int[14];

    private static int count(int card) {
        indexSize++;
        if (index[card] == 0) {
            index[card] = indexSize;
            return 0;
        } else {
            int ind = index[card];
            int count = indexSize - ind + 1;
            for (int i = 1; i < 14; i++) {
                if (index[i] >= ind && index[i] < indexSize) {
                    index[i] = 0;
                }
            }
            indexSize -= count;
            return count;
        }

    }
}
