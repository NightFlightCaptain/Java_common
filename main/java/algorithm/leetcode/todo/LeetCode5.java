package algorithm.leetcode.todo;

/**
 * 【最长回文子串】
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/11/28 18:13
 */
public class LeetCode5 {
    public String longestPalindrome(String s) {
        return forceDp2(s);
    }


    /**
     * 普通的暴力法需要O(n^3)的时间复杂度
     * <p>
     * 暴力法的优化，用一个数组表示从i到j是否是回文。
     * 这也我们如果要判断从i到j是否是回文的话就只需要 s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]
     * 时间复杂度O（n^2) 空间复杂度O(n^2)
     *
     * @param s
     * @return
     */
    private String forceDp(String s) {
        int length = s.length();
        if (length == 0) {
            return "";
        }
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        String res = s.substring(0, 1);
        for (int len = 2; len <= length; len++) {
            for (int start = 0; start + len <= length; start++) {
                if (len == 2) {
                    if (s.charAt(start) == s.charAt(start + len - 1)) {
                        dp[start][start + len - 1] = true;
                        if (len > res.length()) {
                            res = s.substring(start, start + len);
                        }
                    }
                } else {
                    if (s.charAt(start) == s.charAt(start + len - 1) && dp[start + 1][start + len - 2]) {
                        dp[start][start + len - 1] = true;
                        if (len > res.length()) {
                            res = s.substring(start, start + len);
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 暴力法的再次优化
     * <p>
     * 时间复杂度O（n^2) 空间复杂度O(n)
     *
     * @return
     */
    private String forceDp2(String s) {
        int length = s.length();
        //p[j]表示从当前值到j是否为回文串,因为从来都是下一回合用上一回合的p，所以p实际表示的是从start+1到j是否为回文
        boolean[] p = new boolean[length];
        String res = "";
        for (int start = length - 1; start >= 0; start--) {
            for (int end = length - 1; start <= end; end--) {
                boolean isCurP = s.charAt(start) == s.charAt(end) && (end - start <= 1 || p[end - 1]);
                if (isCurP) {
                    p[end] = true;
                    if (end - start + 1 > res.length()) {
                        res = s.substring(start, end + 1);
                    }
                } else {
                    p[end] = false;
                }
            }
        }
        return res;
    }

    /**
     * 中心扩展：以每一个元素为中心往两边扩展，找到最长的回文串。
     * 需要考虑奇数和偶数的情况
     * 时间复杂度O（n^2) 空间复杂度O(1)
     *
     * @param s
     * @return
     */
    private String expand(String s) {
        int length = s.length();

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < length; i++) {
            int curLength = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));

            if (curLength > endIndex - startIndex + 1) {
                startIndex = i - (curLength + 1) / 2 + 1;
                endIndex = i + curLength / 2;
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        LeetCode5 solution = new LeetCode5();
        System.out.println(solution.longestPalindrome(""));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome("aacdefcaa"));
    }
}
