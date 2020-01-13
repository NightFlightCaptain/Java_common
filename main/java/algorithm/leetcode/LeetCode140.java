package algorithm.leetcode;

import java.util.*;

/**
 * 【单词拆分 II】
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/10 14:16
 */
public class LeetCode140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        /* map中存放的以key为第一位的字符串的集合 */
        Map<Integer, List<String>> map = new HashMap<>();
        return backTrack(s, new HashSet<>(wordDict), map, 0);
//        return dpMethod(s, wordDict);
    }

    /*  */

    private List<String> backTrack(String s, Set<String> wordDict, Map<Integer, List<String>> map, int start) {
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = backTrack(s, wordDict, map, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + ("".equals(l) ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    /* 会超时！！！！ */

    private List<String> dpMethod(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        // 存放以当前为起点的下标
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> inital = new LinkedList<>();
        inital.add("");
        dp[s.length()] = inital;

        for (int end = s.length(); end > 0; end--) {
            LinkedList<String> res = dp[end];
            if (res == null){
                continue;
            }
            for (int start = end - 1; start >= 0; start--) {
                if (set.contains(s.substring(start, end))) {
                    LinkedList<String> list = dp[start];
                    if (list == null) {
                        list = new LinkedList<>();
                    }
                    for (String s1 : res) {
                        list.add(s.substring(start, end) + " " + s1);
                    }
                    dp[start] = list;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LeetCode140 solution = new LeetCode140();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("appl", "apple", "pen")));
        System.out.println(solution.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(solution.wordBreak("catsanddog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(solution.wordBreak("abca", Arrays.asList("bc", "ca")));
        System.out.println(solution.wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb")));
        System.out.println(solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));

    }
}
