package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 【组合总和】
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/3 20:22
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        recursive(candidates,target,result,new ArrayList<>(),0,0);
        return result;
    }

    private void recursive(int[] candidates, int target, List<List<Integer>> result,
                           List<Integer> sum, int curSum,int curIndex) {
        for (int i =curIndex;i<candidates.length;i++) {
            if (curSum + candidates[i] == target) {
                sum.add(candidates[i]);
                result.add(new ArrayList<>(sum));
                sum.remove(sum.size()-1);
                break;
            } else if (curSum + candidates[i] > target) {
                break;
            } else {
                sum.add(candidates[i]);
                curSum += candidates[i];
                recursive(candidates, target, result, sum, curSum,i);
                curSum -= candidates[i];
                sum.remove(sum.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode39 solution = new LeetCode39();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
