package algorithm.realExam.NetEase2018InternshipJava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 【牛牛找工作】
 * <p>
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * <p>
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * <p>
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个整数表示他能得到的最高报酬。如果他找不到工作，则输出0。一个工作可以被多个人选择。
 * <p>
 * 输入例子1:
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 * <p>
 * 输出例子1:
 * 100
 * 1000
 * 1001
 *
 * @author: 小栗旬
 * @Date: 2019/11/1 16:19
 */
public class NetEase2018InternshipJavaA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Work[] works = new Work[n];
        for (int i = 0; i < n; i++) {
            works[i] = new Work(scanner.nextLong(), scanner.nextLong());
        }
        Person[] persons = new Person[m];
        for (int i = 0; i < m; i++) {
            persons[i] = new Person(i, scanner.nextLong());
        }

        Arrays.sort(persons, (Comparator.comparingLong(o -> o.ability)));
        Arrays.sort(works, (Comparator.comparingLong(o -> o.diff)));
        int workIndex = 0;
        int personIndex = 0;
        long curPrice = 0;
        while (personIndex < m) {
            while (workIndex < n && persons[personIndex].ability >= works[workIndex].diff) {
                curPrice = Math.max(curPrice, works[workIndex].price);
                workIndex++;
            }
            persons[personIndex].price = curPrice;
            personIndex++;
        }
        while (personIndex < m) {
            persons[personIndex++].price = curPrice;
        }
        Arrays.stream(persons).sorted(Comparator.comparingLong(o -> o.index)).forEachOrdered(o -> System.out.println(o.price));
    }

    static class Work {
        long diff;
        long price;

        public Work(long diff, long price) {
            this.diff = diff;
            this.price = price;
        }
    }

    static class Person {
        long index;
        long ability;
        long price;

        public Person(long index, long ability) {
            this.index = index;
            this.ability = ability;
        }
    }
}


