package algorithm.realExam.ByteDance2018Server2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * 【字母交换】
 * <p>
 * 【编码题】字符串S由小写字母构成，长度为n。定义一种操作，每次都可以挑选字符串中任意的两个相邻字母进行交换。询问在至多交换m次之后，字符串中最多有多少个连续的位置上的字母相同？
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 第一行为一个字符串S与一个非负整数m。(1 <= |S| <= 1000, 1 <= m <= 1000000)
 * <p>
 * 输出描述:
 * 一个非负整数，表示操作之后，连续最长的相同字母数量。
 * <p>
 * 输入例子1:
 * abcbaa 2
 * <p>
 * 输出例子1:
 * 2
 * <p>
 * 例子说明1:
 * 使2个字母a连续出现，至少需要3次操作。即把第1个位置上的a移动到第4个位置。
 * 所以在至多操作2次的情况下，最多只能使2个b或2个a连续出现。
 *
 * @author: 小栗旬
 * @Date: 2019/10/7 15:07
 */
public class ByteDance2018Server2C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String string = line.split(" ")[0];
        int count = Integer.valueOf(line.split(" ")[1]);

        char[] chars = string.toCharArray();
        int length = chars.length;
        Map<Character, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], new LinkedList<>());
            }
            map.get(chars[i]).add(i);
        }

        int max = 0;

        /* 按照不同的字母分类，根据每一种字母的位置来决定
         * 将这些字母往中间靠是最省移动次数的做法  */
        for (Map.Entry<Character, LinkedList<Integer>> entry : map.entrySet()) {
            LinkedList<Integer> linkedList = entry.getValue();
            int listLength = linkedList.size();
            //dp[i][j]表示的是将从i到j的字母移动到一起需要的次数
            int[][] dp = new int[listLength][listLength];
            for (int len = 2; len <= listLength; len++) {
                for (int i = 0; i < listLength - len + 1; i++) {
                    dp[i][i + len - 1] = dp[i + 1][i + len - 2]
                            + linkedList.get(i + len - 1) - linkedList.get(i) - len + 1;
                    if (dp[i][i+len-1] <= count){
                        max = Math.max(max,len);
                    }
                }
            }
        }
        System.out.println(max);


    }
}
