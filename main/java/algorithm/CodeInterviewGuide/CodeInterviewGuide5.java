package algorithm.CodeInterviewGuide;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author: 小栗旬
 * @Date: 2019/8/10 9:34

 * 设计getMin功能的栈

 * <p>
 * 题目描述
 * 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 输入描述:
 * 第一行输入一个整数N，表示对栈进行的操作总数。
 * <p>
 * 下面N行每行输入一个字符串S，表示操作的种类。
 * <p>
 * 如果S为"push"，则后面还有一个整数X表示向栈里压入整数X。
 * <p>
 * 如果S为"pop"，则表示弹出栈顶操作。
 * <p>
 * 如果S为"getMin"，则表示询问当前栈中的最小元素是多少。
 * 输出描述:
 * 对于每个getMin操作，输出一行表示当前栈中的最小元素是多少。
 * 示例1
 * 输入
 * <p>
 * 6
 * push 3
 * push 2
 * push 1
 * getMin
 * pop
 * getMin
 * 输出
 * <p>
 * 1
 * 2
 */
public class CodeInterviewGuide5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        scanner.nextLine();
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> minValues = new LinkedList<>();
        //其实仔细思考，针对这道题，我们可能只需要minValues这一个栈就够了，stack里面的数据从来没有被取出来郭
        //具体做法就是判断minValues不保存存进来的具体值，如果保存的值比当前的最小值大，那我们就再保存一次最小值
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] params = s.split(" ");
            if ("push".equals(params[0])){
                int num = Integer.valueOf(params[1]);
                stack.push(num);
                if (minValues.isEmpty()||num<=minValues.getFirst()){
                    minValues.addFirst(num);
                }
            }else if ("pop".equals(params[0])){
                int t = stack.pop();
                if (t==minValues.getFirst()){
                    minValues.removeFirst();
                }

            }else if ("getMin".equals(params[0])){
                System.out.println(minValues.getFirst());
            }
        }
    }
}