package algorithm.CodeInterviewGuide;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: 小栗旬
 * @Date: 2019/8/10 10:14
 *
 *
 * 用递归函数和栈逆序一个栈.
 *
 *
 * 题目描述
一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，
【【但是只能用递归函数来实现，不能用其他数据结构】】。

输入描述:
输入数据第一行一个整数N为栈中元素的个数。

接下来一行N个整数X_i表示从栈顶依次到栈底的每个元素。

输出描述:
输出一行表示栈中元素逆序后的每个元素
示例1
输入

5
1 2 3 4 5
输出

5 4 3 2 1
 */
public class CodeInterviewGuide7 {
    //【莫名其妙的垃圾题目】
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int N = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i =0;i<N;i++){
            stack.push(scanner.nextInt());
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
//        reverse(stack);
    }

    private static void reverse(int v){

    }

}
