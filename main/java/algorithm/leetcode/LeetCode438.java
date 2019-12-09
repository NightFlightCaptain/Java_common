package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 【找到字符串中所有字母异位词】
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/8 22:33
 */
public class LeetCode438 {
    /*
    *
    *  这套题目给定的参数都是小写字母，可以考虑用数组代替map，提高性能
    *  【和LeetCode76有关】
    *
    * */


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>(p.length());
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> curMap = new HashMap<>(p.length());
        int unsatisfiedChar = map.size();

        int left = 0, right = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            //先右指针移动，直到满足条件(unsatisfiedChar==0)
            if (map.containsKey(rightChar)) {
                curMap.put(rightChar, curMap.getOrDefault(rightChar, 0) + 1);
                if (curMap.get(rightChar).equals(map.get(rightChar))) {
                    unsatisfiedChar--;
                }
            }
            right++;

            //满足条件的情况下
            while (unsatisfiedChar == 0) {
                char leftChar = s.charAt(left);
                //如果长度条件也满足，则加入
                if (right - left == p.length()) {
                    result.add(left);
                }
                //不管长度条件是否满足，都要在curMap中删去这个left，然后left++
                if (map.containsKey(leftChar)) {
                    curMap.put(leftChar, curMap.get(leftChar) - 1);
                    //如果这个char当前计数小于需要的（因为有可能这个char有多余的，uns是不会增加的）
                    if (curMap.get(leftChar) < map.get(leftChar)) {
                        unsatisfiedChar++;
                    }
                }
                left++;
            }
        }
        return result;
    }

    /**
     * 自己写的解答，写法难看
     *
     * @param s
     * @param p
     * @return
     */
    private List<Integer> selfSolution(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>(p.length());
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> curMap = new HashMap<>(p.length());
        int unsatisfiedChar = map.size();

        int left = 0, right = 0;

        while (right <= s.length()) {
            if (right - left < p.length()) {
                if (right == s.length()) {
                    break;
                }
                char rightChar = s.charAt(right);
                if (map.containsKey(rightChar)) {
                    curMap.put(rightChar, curMap.getOrDefault(rightChar, 0) + 1);
                    if (curMap.get(rightChar).equals(map.get(rightChar))) {
                        unsatisfiedChar--;
                    }
                    right++;
                } else {
                    curMap.clear();
                    unsatisfiedChar = map.size();
                    right++;
                    left = right;
                }
            } else {
                char leftChar = s.charAt(left);
                if (unsatisfiedChar == 0) {
                    result.add(left);
                }
                curMap.put(leftChar, curMap.get(leftChar) - 1);
                if (curMap.get(leftChar).equals(map.get(leftChar) - 1)) {
                    unsatisfiedChar++;
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode438 solution = new LeetCode438();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abaacbabc", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
        System.out.println(solution.findAnagrams("aaaa", "ab"));
        System.out.println(solution.findAnagrams("aaaa", "aaa"));
        System.out.println(solution.findAnagrams("cdrdfdsdff", "df"));
    }
}
