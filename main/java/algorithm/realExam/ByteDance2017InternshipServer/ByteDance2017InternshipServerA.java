package algorithm.realExam.ByteDance2017InternshipServer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【最大映射】
 * <p>
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * <p>
 * <p>
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。 n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个数，表示最大和是多少。
 * <p>
 * <p>
 * 输入例子1:
 * 2
 * ABC
 * BCA
 * <p>
 * 输出例子1:
 * 1875
 *
 * @author: 小栗旬
 * @Date: 2019/10/29 9:25
 */
public class ByteDance2017InternshipServerA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        Node[] values = new Node[10];
        for (int i = 0; i < 10; i++) {
            values[i] = new Node();
        }
        for (int i = 0; i < n; i++) {
            String string = strings[i];
            int length = string.length();
            for (int j = 0; j < length; j++) {
                int index = string.charAt(j) - 65;
                if (j == 0) {
                    values[index].first = true;
                }
                values[index].value += (long) Math.pow(10, length - j - 1);
            }
        }

        Arrays.sort(values);
        int zeroIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (!values[i].first) {
                zeroIndex = i;
                values[i].value =0;
                break;
            }
        }
        long res = 0;
        int numCount = 9;
        for (int i = 9; i >= 0; i--) {
            res += values[i].value * numCount;
            if (i != zeroIndex){
                numCount--;
            }
        }
        System.out.println(res);
    }
}

class Node implements Comparable<Node> {
    long value;
    boolean first;

    public Node() {
        value = 0;
        first = false;
    }

    /* long 类型永远不要强制转为int */
    @Override
    public int compareTo(Node o) {
        if (this.value >= o.value) {
            return 1;
        } else {
            return -1;
        }
    }
}


