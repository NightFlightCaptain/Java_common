package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 【全排列】
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/4 20:14
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> per = new ArrayList<>();
        addANum(result,per,nums);
        return result;
    }

    private void addANum(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])){
                list.add(nums[i]);
                addANum(result,list,nums);
                list.remove(list.size() -1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode46 solution = new LeetCode46();
        System.out.println(solution.permute(new int[]{1, 2, 3}));
        System.out.println(solution.permute(new int[]{}));
    }
}
