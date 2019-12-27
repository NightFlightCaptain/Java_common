package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 【子集】
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/27 10:01
 */
public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        int length = nums.length;
        result.add(list);
        for (int i = 0; i < length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }

    private void add(int[] nums, List<Integer> list, int index, boolean[] hasBeen, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (!hasBeen[i]) {
                list.add(nums[i]);
                hasBeen[i] = true;
                add(nums, list, index + 1, hasBeen, result);
                hasBeen[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode78 solution = new LeetCode78();
        System.out.println(solution.subsets(new int[]{1, 2, 3}));
    }
}
