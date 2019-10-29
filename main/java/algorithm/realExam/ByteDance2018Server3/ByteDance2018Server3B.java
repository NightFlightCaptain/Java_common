package algorithm.realExam.ByteDance2018Server3;

import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/10/8 13:47
 */
public class ByteDance2018Server3B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        long[] peopleAfter = new long[n];
        long[] peopleBefore = new long[n];

        long minPeople = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            peopleAfter[i] = scanner.nextInt();
            if (i > 0 && peopleAfter[i] <= minPeople) {
                minPeople = peopleAfter[i];
            }
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            peopleAfter[i] -= minPeople;
            count += minPeople;

        }
        int index = x-1;
        while (true) {
            if (peopleAfter[index] == 0) {
                peopleBefore[index] += count;
                break;
            }
            peopleAfter[index--]--;
            if (index == -1) {
                index = n - 1;
            }
            count++;

        }
        for (int i =0;i<n;i++){
            if (index != i){
                peopleBefore[i] = peopleAfter[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (long i : peopleBefore) {
            stringBuilder.append(" ").append(i);
        }
        System.out.println(stringBuilder.substring(1));
    }
}
