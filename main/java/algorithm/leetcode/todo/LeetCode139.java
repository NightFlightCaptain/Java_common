package algorithm.leetcode.todo;

import java.util.*;

/**
 * 【单词拆分】
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/5 16:18
 */
public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
//        return backTrack(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
//        return BFS(s, new HashSet<>(wordDict));
        return dpMethod(s, wordDict);
    }


    /* 1、优化的暴力回溯法 */

    /*从s入手，两次遍历分割s，而不是根据wordDict来分割s*/

    /* 时间复杂度O(n^2) 实际上就是i为起点，j为终点，判断每一个从i到j是否能够存在在set中。
     * 假设要判断2-7是否成功，在某一步骤中，分为了判断2-4和5-7是否存在在set中。
     * 假设start =2，那么一定是先判断2-3是否可行，然后2-4是否可行，在判断2-4是否可行的时候就会判断5-7是否可行
     *
     * 那么在分为2-4和5-7时可以直接得出5-7的结论
     *
     * */

    private boolean backTrack(String s, Set<String> set, int start, Boolean[] memo) {

        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && backTrack(s, set, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    /* 2、宽度优先搜索 */
    /* 核心也是 不是根据wordDict里面有什么，而是根据s来一步步拆分
     * 构建一棵树，树里面存放的就是目前能到达的最后端 */

    private boolean BFS(String s, Set<String> wordDict) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDict.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
        }
        return false;

    }

    /*  3、动态规划方法*/

    private boolean dpMethod(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int start = 1; start < s.length() + 1; start++) {
            boolean isStart = false;
            for (int end = start; end <= s.length() + 1; end++) {
                isStart = true;
                if (wordSet.contains(s.substring(start - 1, end - 1)) && dp[start - 1]) {
                    dp[end - 1] = true;
                }
            }
            if (!isStart){
                return false;
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        LeetCode139 solution = new LeetCode139();
        System.out.println(solution.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("appl", "apple", "pen")));
        System.out.println(solution.wordBreak("applepenapple", Arrays.asList("apple", "appl", "epen")));
        System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(solution.wordBreak("abca", Arrays.asList("bc", "ca")));
        System.out.println(solution.wordBreak("bccdbacdbdacddabbaaaadababadad", Arrays.asList("cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb", "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd", "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb", "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb")));
    }
}
