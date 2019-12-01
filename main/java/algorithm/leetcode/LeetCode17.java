package algorithm.leetcode;

import java.util.*;

/**
 * 【电话号码的字母组合】
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/1 18:56
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        Map<Character, List<Character>> map = new HashMap<>(length);
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        if(length==0){
            return result;
        }
        StringBuilder stringBuilder = new StringBuilder();
        recursive(stringBuilder, map, result, digits, 0);
        return result;
    }

    private void recursive(StringBuilder sb, Map<Character, List<Character>> map,
                           List<String> result, String digits, int sortNum) {
        if (sortNum == digits.length()) {
            result.add(sb.toString());
            return;
        }
        List<Character> characters = map.get(digits.charAt(sortNum));
        for (int i = 0; i < characters.size(); i++) {
            sb.append(characters.get(i));
            recursive(sb, map, result, digits, sortNum + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        LeetCode17 solution = new LeetCode17();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations(""));
        System.out.println(solution.letterCombinations("295"));
    }
}
