package algorithm.realExam.NetEase2019Internship;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【牛牛找工作】
 * <p>
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
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
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
 * @Date: 2019/10/11 9:02
 */
public class NetEase2019InternshipA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            int p = scanner.nextInt();
            Job job = new Job(d, p);
            jobs[i] = job;
        }
        Arrays.sort(jobs, (o1, o2) -> (o1.diff - o2.diff));
        Person[] persons = new Person[n];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            persons[i] = new Person(i, a);
        }
        Arrays.sort(persons, (o1, o2) -> o1.ability - o2.ability);

        int jobIndex = 0;
        int[] res = new int[m];
        int curPrice = 0;
        for (int i = 0; i < m; i++) {
            while (true) {
                if (jobIndex < n && persons[i].ability >= jobs[jobIndex].diff) {
                    curPrice = Math.max(curPrice, jobs[jobIndex].price);
                    jobIndex++;
                } else {
                    res[persons[i].index] = curPrice;
                    break;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(res[i]);
        }
    }
}

class Job {
    int diff;
    int price;

    public Job(int diff, int price) {
        this.diff = diff;
        this.price = price;
    }
}

class Person {
    int index;
    int ability;

    public Person(int index, int ability) {
        this.index = index;
        this.ability = ability;
    }
}
