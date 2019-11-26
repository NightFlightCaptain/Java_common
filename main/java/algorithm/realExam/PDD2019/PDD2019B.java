package algorithm.realExam.PDD2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【种树】
 * <p>
 * 小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。但是他希望任意两棵相邻的树不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。
 * <p>
 * 输入描述:
 * 第一行包含一个正整数 N，表示树的品种数量。
 * 第二行包含 N 个正整数，第 i (1 <= i <= N) 个数表示第 i 个品种的树的数量。
 * 数据范围：
 * 1 <= N <= 1000
 * 1 <= M <= 2000
 * <p>
 * 输出描述:
 * 输出一行，包含 M 个正整数，分别表示第 i 棵树的品种编号 (品种编号从1到 N)。若存在多种可行方案，则输出字典序最小的方案。若不存在满足条件的方案，则输出"-"。
 * <p>
 * 输入例子1:
 * 3
 * 4 2 1
 * <p>
 * 输出例子1:
 * 1 2 1 2 1 3 1
 *
 * @author: 小栗旬
 * @Date: 2019/11/25 20:55
 */
public class PDD2019B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int totalCount = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            totalCount += nums[i];
        }

        if (nums[maxIndex] > ((totalCount + 1) / 2)) {
            System.out.println("-");
        }

        int resCount = totalCount;
        int[] resNums = Arrays.copyOf(nums, nums.length);

        StringBuilder stringBuilder = new StringBuilder();

        int lastIndex = -1;
        for (int i = 0; i < totalCount; i++) {
            int notZeroIndex = -1;
            boolean moreThanHalf = false;
            for (int j = 0; j < n; j++) {
                if (notZeroIndex == -1 && j != lastIndex && resNums[j] != 0) {
                    notZeroIndex = j;
                }
                if (j != lastIndex && resNums[j] > resCount / 2) {
                    stringBuilder.append(" ").append(j + 1);
                    resCount--;
                    resNums[j]--;
                    lastIndex = j;
                    moreThanHalf = true;
                    break;
                }
            }

            if (!moreThanHalf) {
                stringBuilder.append(" ").append(notZeroIndex + 1);
                resCount--;
                resNums[notZeroIndex]--;
                lastIndex = notZeroIndex;
            }

        }
        System.out.println(stringBuilder.substring(1));

    }
}
