package algorithm.realExam.PDD2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【小熊吃糖】
 * <p>
 * 有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。前面的小熊吃饱了，后面的小熊才能吃。
 * 每只小熊有一个饥饿值，每次进食的时候，小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
 * 现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
 * 求所有小熊进食完之后，每只小熊剩余的饥饿值。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
 * 第二行m个正整数，每个表示着颗糖能填充的饥饿值。
 * 接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
 * 题目中所有输入的数值小于等于100。
 * <p>
 * 输出描述:
 * 输出n行，每行一个整数，代表每只小熊剩余的饥饿值。
 * <p>
 * 输入例子1:
 * 2 5
 * 5 6 10 20 30
 * 4 34
 * 3 35
 * <p>
 * 输出例子1:
 * 4
 * 0
 * <p>
 * 例子说明1:
 * 第一只小熊吃了第5颗糖
 * 第二只小熊吃了第4颗糖
 * 第二只小熊吃了第3颗糖
 * 第二只小熊吃了第1颗糖
 *
 * @author: 小栗旬
 * @Date: 2019/10/31 13:45
 */
public class PDD2018E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] sugar = new int[m];
        boolean[] sugerEaten = new boolean[m];
        for (int i = 0; i < m; i++) {
            sugar[i] = scanner.nextInt();
        }
        Arrays.sort(sugar);

        Bear[] bears = new Bear[n];
        int[][] fights = new int[n][2];
        for (int i = 0; i < n; i++) {
            bears[i] = new Bear(scanner.nextInt(), scanner.nextInt());
            fights[i][0] = i;
            fights[i][1] = bears[i].fight;
        }
        Arrays.sort(fights, (o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (!sugerEaten[j] && sugar[j] <= bears[fights[i][0]].hunger) {
                    bears[fights[i][0]].hunger -= sugar[j];
                    bears[fights[i][0]].sugerCount++;
                    sugerEaten[j] = true;
                }
            }
        }
        Arrays.stream(bears).forEachOrdered(o -> System.out.println(o.hunger));
    }
}

class Bear {
    int fight;
    int hunger;
    int sugerCount = 0;

    public Bear(int fight, int hunger) {
        this.fight = fight;
        this.hunger = hunger;
    }
}