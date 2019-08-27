package algorithm.CodeInterviewGuide;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: 小栗旬
 * @Date: 2019/8/27 15:18
 * <p>
 * 题目描述
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此之外，可以申请新的变量，但不能申请额外的数据结构。
 * 如何完成排序？
 * <p>
 * 输入描述:
 * 第一行输入一个N，表示栈中元素的个数
 * 第二行输入N个整数a_i，表示栈顶到栈底的各个元素
 * <p>
 * 输出描述:
 * 输出一行表示排序后的栈中栈顶到栈底的各个元素。
 * <p>
 * 示例1
 * 输入
 * 5
 * 5 8 4 3 6
 * 输出
 * 8 6 5 4 3
 */
public class CodeInterviewGuide13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        LinkedList<Integer> oldStack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            oldStack.add(scanner.nextInt());
        }

        if (n == 1) {
            System.out.println(oldStack.pop());
            return;
        }

        Stack<Integer> newStack = new Stack<>();
        for (int j = n; j > 0; j--) {
            int temp = oldStack.pop();
            for (int i = 1; i < j; i++) {
                int temp2 = oldStack.pop();
                if (temp2 < temp) {
                    newStack.push(temp);
                    temp = temp2;
                } else {
                    newStack.push(temp2);
                }
            }
            oldStack.push(temp);
            for (int i = 1; i < j; i++) {
                oldStack.push(newStack.pop());
            }


        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<n;i++){
            stringBuilder.append(" ").append(oldStack.pop());
        }
        System.out.println(stringBuilder.substring(1));
    }
}
