package algorithm.leetcode;

import java.util.HashMap;

/**
 * 【无重复字符的最长子串】
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/11/28 11:23
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int maxLenght = 0;
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= startIndex) {
                startIndex = map.get(c) + 1;
            } else {
                maxLenght = Math.max(maxLenght, i - startIndex + 1);
            }
            map.put(c, i);
        }
        return maxLenght;
    }

    public static void main(String[] args) {
        LeetCode3 solution = new LeetCode3();
        System.out.println(solution.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
