package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 【删除无效的括号】
 * <p>
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * <p>
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 * <p>
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 * <p>
 * 输入: ")("
 * 输出: [""]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/2/13 19:10
 */
public class LeetCode301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        int length = s.length();
        int leftCount = 0;
        int rightCount = 0;
        // 计算多出来的(或者)的个数
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                leftCount++;
            } else if (')' == c) {
                if (leftCount != 0) {
                    leftCount--;
                } else {
                    rightCount++;
                }
            }
        }
        dfs(s, 0, leftCount, rightCount, res);
        return res;
    }

    /**
     * 不断删除多余的(或者)，直到符合要求
     *
     * @param s          字符串
     * @param curIndex   当前位置
     * @param leftCount  多出的(
     * @param rightCount 多出的)
     * @param res        返回数组
     */
    private void dfs(String s, int curIndex, int leftCount, int rightCount, List<String> res) {
        //leftCount和rightCount都为0，说明此时已经减到最少了
        if (leftCount == 0 && rightCount == 0) {
            if (check(s)) {
                res.add(s);
            }
            return;
        }

        for (int i = curIndex; i < s.length(); i++) {
            // 去重，如果当前位置和前面的位置一样，那么说明不用去重,最开始的位置为curIndex,小于curIndex的位置都取不到
            if (i - 1 >= curIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (leftCount > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()),
                        i, leftCount - 1, rightCount, res);
            }
            if (rightCount > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1, s.length()),
                        i, leftCount, rightCount - 1, res);
            }
        }
    }

    /**
     * 判断是否符合要求
     *
     * @param s
     * @return
     */
    private boolean check(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if ('(' == c) {
                count++;
            } else if (')' == c) {
                if (count == 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        LeetCode301 solution = new LeetCode301();
        System.out.println(solution.removeInvalidParentheses("()())()"));
        System.out.println(solution.removeInvalidParentheses("(a)())()"));
        System.out.println(solution.removeInvalidParentheses(")("));
        System.out.println(solution.removeInvalidParentheses("((a)a(a))a))"));
    }
}
