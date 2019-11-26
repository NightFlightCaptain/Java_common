package algorithm.realExam.PDD2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【选靓号】
 * <p>
 * A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
 * 小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
 * 给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？
 * <p>
 * 输入描述:
 * 第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
 * 第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
 * 数据范围：
 * 2 <= K <= N <= 10000
 * <p>
 * 输出描述:
 * 第一行包含一个整数，表示修改成一个靓号，最少需要的金额。
 * 第二行包含 N 个数字字符，表示最少花费修改的新手机号。若有多个靓号花费都最少，则输出字典序最小的靓号。
 * <p>
 * 输入例子1:
 * 6 5
 * 787585
 * <p>
 * 输出例子1:
 * 4
 * 777577
 * <p>
 * 例子说明1:
 * 花费为4的方案有两种：777577与777775，前者字典序更小。
 *
 * @author: 小栗旬
 * @Date: 2019/11/25 20:23
 */
public class PDD2019A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String originPhone = scanner.nextLine();
        Number[] numbers = new Number[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = new Number(i, originPhone.charAt(i) - '0');
        }

        int diffCount = Integer.MAX_VALUE;
        char[] finalRes = new char[n];
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                numbers[j].setTarget(i);
            }
            Arrays.sort(numbers, (o1, o2) -> {
                //diff 小的在前面
                if (o1.diff > o2.diff) {
                    return 1;
                } else if (o1.diff < o2.diff) {
                    return -1;
                }

                //当diff相同时，分为origin相同或者不同
                //当origin不同时，将大的origin放在前面，因为放在前面更有可能被替换
                if (o1.origin > o2.origin) {
                    return -1;
                } else if (o1.origin < o2.origin) {
                    return 1;
                }

                //当origin相同时，要考虑origin和target的关系
                //如果origin>target,index小的在前面——先变index小的
                //如果origin<target,index小的在后面——先变index大的
                if (o1.target > o1.origin) {
                    return o2.index - o1.index;
                } else {
                    return o1.index - o2.index;
                }

            });
            int sum = 0;
            char[] res = new char[n];
            for (int j = 0; j < n; j++) {
                //前k个变成target，后面的保持origin
                if (j < k) {
                    sum += numbers[j].diff;
                    res[numbers[j].index] = (char) ('0' + numbers[j].target);
                } else {
                    res[numbers[j].index] = (char) ('0' + numbers[j].origin);
                }
            }
            if (sum < diffCount) {
                diffCount = sum;
                finalRes = res;
            } else if (sum == diffCount) {
                int index = 0;
                while (index < n) {
                    if (finalRes[index] == res[index]) {
                        index++;
                    } else {
                        if (finalRes[index] > res[index]) {
                            finalRes = res;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(diffCount);
        System.out.println(finalRes);


    }

    static class Number {
        int index;
        int origin;
        int target;
        int diff;

        public Number(int index, int origin) {
            this.index = index;
            this.origin = origin;
        }

        public void setTarget(int target) {
            this.target = target;
            this.diff = Math.abs(origin - target);
        }

    }
}
