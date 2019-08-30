package algorithm.CodeInterviewGuide;

import java.util.Scanner;
import java.util.Stack;

/**
 * 【用栈来求解汉诺塔问题】
 * <p>
 * 题目描述
 * 汉诺塔问题比较经典，这里修改一下游戏规则：现在限制不能从最左侧的塔直接移动到最右侧，也不能从最右侧直接移动到最左侧，而是必须经过中间。
 * 求当塔有n层的时候，打印最优移动过程和最优移动总步数。
 * <p>
 * 输入描述:
 * 输入一个数n，表示塔层数
 * 输出描述:
 * 按样例格式输出最优移动过程和最优移动总步数
 * <p>
 * 示例1
 * 输入
 * 2
 * 输出
 * Move 1 from left to mid
 * Move 1 from mid to right
 * Move 2 from left to mid
 * Move 1 from right to mid
 * Move 1 from mid to left
 * Move 2 from mid to right
 * Move 1 from left to mid
 * Move 1 from mid to right
 * It will move 8 steps.
 * 说明
 * 当塔数为两层时，最上层的塔记为1，最下层的塔记为2
 * 备注:
 * 1<=n<=12
 *
 * @author: 小栗旬
 * @Date: 2019/8/30 20:08
 */
public class CodeInterviewGuide22 {
    private static final String LEFT = "left";
    private static final String MID = "mid";
    private static final String RIGHT = "right";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        fromStackToStack(n);
        System.out.println("-----");
//        recursion(n);
    }

    /* 递归算法 */
    private static void recursion(int n) {
        System.out.println("It will move " + process(n, LEFT, RIGHT) + " steps.");
    }

    private static int process(int num, String from, String to) {
        //只剩下一层塔未摆放
        if (num == 1) {
            //如果涉及到中间就是一步
            if (MID.equals(from) || MID.equals(to)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
                //如果是直接从左到右或者从右到左就是两步
            } else {
                System.out.println("Move 1 from " + from + " to " + MID);
                System.out.println("Move 1 from " + MID + " to " + to);
                return 2;
            }
        } else {
            if (MID.equals(from) || MID.equals(to)) {
                //未涉及到的那个汉诺塔
                String another = LEFT.equals(from) || LEFT.equals(to) ? RIGHT : LEFT;
                int part1 = process(num - 1, from, another);
                int part2 = 1;
                System.out.println("Move " + num + " from " + from + " to " + to);
                int part3 = process(num - 1, another, to);
                return part1 + part2 + part3;
            } else {
                String another = MID;
                int part1 = process(num - 1, from, to);
                int part2 = 1;
                System.out.println("Move " + num + " from " + from + " to " + another);
                int part3 = process(num - 1, to, from);
                int part4 = 1;
                System.out.println("Move " + num + " from " + another + " to " + to);
                int part5 = process(num - 1, from, to);
                return part1 + part2 + part3 + part4 + part5;
            }
        }
    }

    /*非递归算法，使用栈结构 */

    private static Stack<Integer> leftStack = new Stack<>();
    private static Stack<Integer> midStack = new Stack<>();
    private static Stack<Integer> rightStack = new Stack<>();
    private static int count;

    private enum Action {
        /**
         * 无操作
         */
        No,
        /**
         * 从左到中
         */
        LeftToMid,
        /**
         * 从中到左
         */
        MidToLeft,
        /**
         * 从右到中
         */
        RightToMid,
        /**
         * 从中到右
         */
        MidToRight
    }

    /* 在不重复操作的情况下，最优解也就是唯一解 */

    private static void fromStackToStack(int n) {
        //在每个栈里面在最下面设置一个最大值避免空栈的问题
        leftStack.push(Integer.MAX_VALUE);
        midStack.push(Integer.MAX_VALUE);
        rightStack.push(Integer.MAX_VALUE);
        for (int i = n; i >= 1; i--) {
            leftStack.push(i);
        }
        Action[] record = new Action[1];
        record[0] = Action.No;
        while (rightStack.size() != n+1) {
            move(record, Action.MidToLeft, Action.LeftToMid, leftStack, midStack, LEFT, MID);
            move(record, Action.LeftToMid, Action.MidToLeft, midStack, leftStack, MID, LEFT);
            move(record, Action.RightToMid, Action.MidToRight, midStack, rightStack, MID, RIGHT);
            move(record, Action.MidToRight, Action.RightToMid, rightStack, midStack, RIGHT, MID);
        }
        System.out.println("It will move " + count + " steps.");
    }

    /**
     * 一次移动
     * @param record 记录上次是什么操作，通过设置成数组的形式来在方法内的改变在方法外生效
     * @param preNoAct 上一次的操作，也是这一次不能的操作
     * @param nowAct 本次操作
     * @param fromStack 出栈
     * @param toStack 入栈
     * @param from 出栈名
     * @param to 入站名
     */
    private static void move(Action[] record, Action preNoAct, Action nowAct,
                             Stack<Integer> fromStack, Stack<Integer> toStack,
                             String from, String to) {
        if (!record[0].equals(preNoAct) && fromStack.peek() < toStack.peek()) {
            int temp = fromStack.pop();
            toStack.push(temp);
            System.out.println("Move " + temp + " from " + from + " to " + to);
            record[0] = nowAct;
            count++;
        }
    }
}
