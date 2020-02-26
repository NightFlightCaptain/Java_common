package algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 【滑动窗口最大值】
 * <p>
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2020/1/15 15:23
 */
public class LeetCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] res = new int[length - k + 1];
        for (int i = 0; i < length; i++) {
            if (i < k - 1) {
                while (!deq.isEmpty() && nums[deq.getLast()] <= nums[i]) {
                    deq.removeLast();
                }
                deq.addLast(i);
            } else {
                if (!deq.isEmpty() && deq.getFirst() == i - k) {
                    deq.removeFirst();
                }
                while (!deq.isEmpty() && nums[deq.getLast()] <= nums[i]) {
                    deq.removeLast();
                }
                deq.addLast(i);
                res[i - k + 1] = nums[deq.getFirst()];
            }
        }
        return res;
    }


    /* 动态规划方法 */
    private int[] dpSolution(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return new int[0];
        }
        // 返回结果数组，存放下标
        int[] res = new int[length - k + 1];

        res[0] = 0;
        // 第一个窗口的值
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[res[0]]) {
                res[0] = i;
            }
        }


        for (int i = k; i < length; i++) {
            // 当前位置的值比上一个窗口的最大值大
            if (nums[i] > nums[res[i - k]]) {
                res[i - k + 1] = i;
            } else {
                // 上一个窗口最大值的下标与当前位置相差如果小于k，也就是上一个窗口的最大值当前位置可能取到
                if (i - res[i - k] < k) {
                    res[i - k + 1] = res[i - k];
                } else {
                    // 如果上一个窗口的最大值不能取到，则从能取到的第一个位置开始遍历最大值。
                    // 看起来好像是每一次循环都有可能经历这次小循环，但实际上下面的小循环最多也只经过length次
                    res[i - k + 1] = i - k + 1;
                    for (int j = i - k + 2; j <= i; j++) {
                        if (nums[j] >= nums[res[i - k + 1]]) {
                            res[i - k + 1] = j;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = nums[res[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode239 solution = new LeetCode239();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{}, 3)));
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }

}
