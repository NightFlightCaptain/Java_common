package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 【括号生成】
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/1 20:03
 */
public class LeetCode22 {
    public List<String> generateParenthesis(int n) {
        return dpSolution(n);
    }

    private List<String> dpSolution(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));
        lists.add(Collections.singletonList("()"));
        //有i个括号
        for (int i = 2; i <= n; i++) {
            List<String> strings = new ArrayList<>();
            //左边有j个括号
            for (int j = 0; j < i; j++) {
                List<String> leftList = lists.get(j);
                List<String> rightList = lists.get(i - j - 1);
                for (String aLeftList : leftList) {
                    for (String aRightList : rightList) {
                        strings.add("(" + aLeftList + ")" + aRightList);
                    }
                }
            }
            lists.add(strings);
        }
        return lists.get(n);
    }

    private List<String> recursiveSolution(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        recursive(stringBuilder, result, n, n);
        return result;

    }

    private void recursive(StringBuilder sb, List<String> result, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
        }
        if (left != 0) {
            sb.append("(");
            recursive(sb, result, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < right) {
            sb.append(")");
            recursive(sb, result, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode22 solution = new LeetCode22();

//        System.out.println(solution.generateParenthesis(2));
        System.out.println(solution.generateParenthesis(3));
        System.out.println(solution.generateParenthesis(4));
    }
}
