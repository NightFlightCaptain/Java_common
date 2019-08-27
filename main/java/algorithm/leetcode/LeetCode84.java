package algorithm.leetcode;

import java.util.LinkedList;

/**
 * * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * @author: 小栗旬
 * @Date: 2019/8/26 14:50
 */
public class LeetCode84 {
    private int largestRectangleArea(int[] heights) {
        int length = heights.length;

        //如果遇到一个较小的柱子，那么该柱子之后的柱子想要和该柱子之前的柱子联通的话，就必须经过该柱子
        //所以当遇到一个柱子比前面的柱子矮，那么前面所有比当前柱子高的的柱子就需要开始计算
        LinkedList<Integer> stack = new LinkedList<>();

        int area = 0;
        stack.push(-1);

        for (int i = 0; i < length; i++) {
            //当出现矩形下降时，计算的是前面的柱子，不计算当前的柱子
            //把比当前柱子高的柱子全部拿出来
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()]) {
                //取比当前柱子高的最近的一个柱子
                int h = heights[stack.pop()];
                //这个柱子到前面一个柱子的距离
                int w = i - stack.peek() - 1;
                area = Math.max(area, w * h);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = length - stack.peek() - 1;
            area = Math.max(area, w * h);
        }
        return area;

    }


    public static void main(String[] args) {
        LeetCode84 solution = new LeetCode84();
        int[] a = {2, 1, 5, 6, 2, 3};
        System.out.println(solution.largestRectangleArea(a));
    }
}
