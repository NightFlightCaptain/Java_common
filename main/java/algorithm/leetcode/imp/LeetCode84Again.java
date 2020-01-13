package algorithm.leetcode.imp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 【柱状图中最大的矩形】
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 小栗旬
 * @Date: 2019/12/27 19:01
 */
public class LeetCode84Again {
    public int largestRectangleArea(int[] heights) {
        return travelsalMethod(heights);
    }

    /*
    * 见 todo包下面的LeetCode84
    * */

    private int travelsalMethod(int[] heights) {
        int length = heights.length;
        int[] leftSmallIndex = new int[length];
        int[] rightSmallIndex = new int[length];

        leftSmallIndex[0] = -1;
        /* 求数组中每一个点 左边第一个比当前位置小的坐标 */
        for (int i = 1; i < length; i++) {
            if (heights[i] > heights[i - 1]) {
                leftSmallIndex[i] = i - 1;
            } else {
                int index = leftSmallIndex[i - 1];
                while (index != -1 && heights[index] > heights[i]) {
                    index = leftSmallIndex[index];
                }
                if (index == -1) {
                    leftSmallIndex[i] = -1;
                } else {
                    leftSmallIndex[i] = index;
                }
            }
        }
        System.out.println(Arrays.toString(leftSmallIndex));

        Stack<Integer> leftStack = new Stack<>();
        leftStack.push(-1);
        return 1;
    }


    private int stackMethod(int[] heights) {
        LinkedList<Integer> stack = new LinkedList<>();
        int length = heights.length;
        int maxArea = 0;
        stack.push(-1);
        for (int i = 0; i < length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int h = heights[stack.poll()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int index = stack.pop();
            int h = heights[index];
            int w = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * w);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LeetCode84Again solution = new LeetCode84Again();
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(nums));
        System.out.println(solution.largestRectangleArea(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 2}));

    }
}
