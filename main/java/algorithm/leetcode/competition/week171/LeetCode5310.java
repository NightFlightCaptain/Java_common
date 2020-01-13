package algorithm.leetcode.competition.week171;

import java.util.Arrays;

/**
 * 【1320. 二指输入的的最小距离】
 * <p>
 * 二指输入法定制键盘在 XY 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处，例如字母 A 位于坐标 (0,0)，字母 B 位于坐标 (0,1)，字母 P 位于坐标 (2,3) 且字母 Z 位于坐标 (4,1)。
 * <p>
 * 给你一个待输入字符串 word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。坐标 (x1,y1) 和 (x2,y2) 之间的距离是 |x1 - x2| + |y1 - y2|。 
 * <p>
 * 注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "CAKE"
 * 输出：3
 * 解释：
 * 使用两根手指输入 "CAKE" 的最佳方案之一是：
 * 手指 1 在字母 'C' 上 -> 移动距离 = 0
 * 手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'C' 到字母 'A' 的距离 = 2
 * 手指 2 在字母 'K' 上 -> 移动距离 = 0
 * 手指 2 在字母 'E' 上 -> 移动距离 = 从字母 'K' 到字母 'E' 的距离  = 1
 * 总距离 = 3
 * 示例 2：
 * <p>
 * 输入：word = "HAPPY"
 * 输出：6
 * 解释：
 * 使用两根手指输入 "HAPPY" 的最佳方案之一是：
 * 手指 1 在字母 'H' 上 -> 移动距离 = 0
 * 手指 1 在字母 'A' 上 -> 移动距离 = 从字母 'H' 到字母 'A' 的距离 = 2
 * 手指 2 在字母 'P' 上 -> 移动距离 = 0
 * 手指 2 在字母 'P' 上 -> 移动距离 = 从字母 'P' 到字母 'P' 的距离 = 0
 * 手指 1 在字母 'Y' 上 -> 移动距离 = 从字母 'A' 到字母 'Y' 的距离 = 4
 * 总距离 = 6
 * 示例 3：
 * <p>
 * 输入：word = "NEW"
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：word = "YEAR"
 * 输出：7
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= word.length <= 300
 * 每个 word[i] 都是一个大写英文字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-to-type-a-word-using-two-fingers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/13 16:12
 */
public class LeetCode5310 {
    public int minimumDistance(String word) {
        int length = word.length();
        int res = Integer.MAX_VALUE;

        /* 左指放在一个位置，右指放在一个位置，指头的移动就是状态的转移，我们可以认为当前左指和右指所在位置以及完成了多少个字符作为状态
          * 然后计算从左指到新的位置和右指到新的位置的距离来计算 */
        /* dp[i][left][right]表示的是走完第i个位置时，左手指在left位置，右手指在right位置所需要的步数 */
        int[][][] dp = new int[length + 1][26][26];
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 1; i <= length; i++) {
            int v = word.charAt(i - 1) - 'A';
            for (int left = 0; left < 26; left++) {
                for (int right = 0; right < 26; right++) {
                    if (dp[i - 1][left][right] != Integer.MAX_VALUE) {
                        dp[i][v][right] = Math.min(dp[i][v][right], dp[i - 1][left][right] + calculateDistance(left, v));
                        dp[i][left][v] = Math.min(dp[i][left][v], dp[i - 1][left][right] + calculateDistance(right, v));
                    }
                    if (i == length) {
                        res = Math.min(res, dp[i][v][right]);
                        res = Math.min(res, dp[i][left][v]);
                    }
                }
            }
        }
        return res;
    }

    private int calculateDistance(int i1, int i2) {
        return Math.abs(i1 % 6 - i2 % 6) + Math.abs(i1 / 6 - i2 / 6);
    }

    public static void main(String[] args) {
        LeetCode5310 solution = new LeetCode5310();
        System.out.println(solution.minimumDistance("CAKE") == 3);
        System.out.println(solution.minimumDistance("HAPPY") ==6);
        System.out.println(solution.minimumDistance("NEW") == 3);
        System.out.println(solution.minimumDistance("YEAR") == 7);
    }


}
