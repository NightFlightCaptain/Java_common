package algorithm.leetcode;

import java.util.Stack;

/**
 * 【最长有效括号】
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/2 20:51
 */
public class LeetCode32 {

    public int longestValidParentheses(String s) {
        return dpSolution(s);
    }

    /**
     * 动态规划算法，时间O(n),空间O(n)
     * dp数组表示以该位置结束的最大的长度
     * 如果是"("，则为0
     * 如果是")"，判断前一个位置，如果是"("，那么就是dp[i]=dp[i-2]+2
     *           如果前一个位置是")，那么再判断[i-1-dp[i-1]]位置是否是"("，也就是判断当前的")"有没有匹配项
     *           如果有，则为dp[i-1]+2。然后还要判断匹配的"("的前一个位置如果是")"，也要把这个位置的dp给加上
     * @param s
     * @return
     */
    private int dpSolution(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (')' == s.charAt(i)) {
                if (i == 0) {
                    continue;
                }

                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2 + (i >= 2 ? dp[i - 2] : 0);
                } else {
                    if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - 2 - dp[i - 1] >= 0) {
                            dp[i] += dp[i - 2 - dp[i - 1]];
                        }
                    }
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }

    /**
     * 用栈解决 时间复杂度O(n),空间复杂度O(n)
     *
     * @param s
     * @return
     */
    private int stackSolution(String s) {
        int maxLen = 0;
        int leftIndex = -1;
        Stack<Integer> stackIndex = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stackIndex.push(i);
            } else {
                if (!stackIndex.isEmpty()) {
                    stackIndex.pop();
                    int index = leftIndex;
                    if (!stackIndex.isEmpty()) {
                        index = stackIndex.peek();
                    }
                    maxLen = i - index > maxLen ? i - index : maxLen;
                } else {
                    leftIndex = i;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LeetCode32 solution = new LeetCode32();
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses(")()())"));
        System.out.println(solution.longestValidParentheses("())(()()"));
        System.out.println(solution.longestValidParentheses(""));
        System.out.println(solution.longestValidParentheses("()(()"));
        System.out.println(solution.longestValidParentheses("(()"));
        System.out.println(solution.longestValidParentheses("()(())"));
        System.out.println(solution.longestValidParentheses("(()())"));
    }
}
