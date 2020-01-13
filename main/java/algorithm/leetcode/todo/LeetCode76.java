package algorithm.leetcode.todo;

import java.util.HashMap;
import java.util.Map;

/**
 * 【最小覆盖子串】
 * <p>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/8 16:17
 */
public class LeetCode76 {
    /*
    * 与leetcode3,leetcode438相关联
    *
    * */
    public String minWindow(String s, String t) {
        return windowMethod(s, t);
    }

    /**
     * 双指针，left，right=0。先移动right主键增大，直到满足条件。然后移动left增加，直到不满足条件，然后继续移动right
     *
     * @param s
     * @param t
     * @return
     */
    private String windowMethod(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //尚未满足的char个数
        int unsatisfiedChar = map.size();
        //存放当前的char情况
        Map<Character, Integer> curMap = new HashMap<>();

        int finalLeft = 0, finalRight = s.length();
        int left = 0, right = 0;
        while (right < s.length()) {
            //尚不满足条件
            if (unsatisfiedChar != 0) {
                //如果这个字符是我们需要的（如果不是，则right直接右移）
                if (map.containsKey(s.charAt(right))) {
                    curMap.put(s.charAt(right), curMap.getOrDefault(s.charAt(right), 0) + 1);
                    if (curMap.get(s.charAt(right)).equals(map.get(s.charAt(right)))) {
                        unsatisfiedChar--;
                    }
                    if (unsatisfiedChar != 0) {
                        right++;
                    }
                } else {
                    right++;
                }
            } else {
                if (right - left < finalRight - finalLeft) {
                    finalLeft = left;
                    finalRight = right;
                }
                if (map.containsKey(s.charAt(left))) {
                    curMap.put(s.charAt(left), curMap.get(s.charAt(left)) - 1);
                    if (curMap.get(s.charAt(left)) < map.get(s.charAt(left))) {
                        unsatisfiedChar++;
                        right++;
                    }
                }
                left++;
            }
        }
        if (finalRight == s.length()) {
            return "";
        }
        return s.substring(finalLeft, finalRight + 1);
    }

    public static void main(String[] args) {
        LeetCode76 solution = new LeetCode76();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution.minWindow("aa", "aa"));
        System.out.println(solution.minWindow("a", "aa"));
        System.out.println(solution.minWindow("bbbbbbaaa", "aaa"));
    }
}
