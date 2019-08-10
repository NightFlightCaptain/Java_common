package algorithm.CodeInterviewGuide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author: 小栗旬
 * @Date: 2019/8/10 10:15
 *
 *由两个栈组成的队列
 *
 * 【题目描述】
用两个栈实现队列，支持队列的基本操作。
【输入描述】
第一行输入一个整数N，表示对队列进行的操作总数。
下面N行每行输入一个字符串S，表示操作的种类。
如果S为"add"，则后面还有一个整数X表示向队列尾部加入整数X。
如果S为"poll"，则表示弹出队列头部操作。
如果S为"peek"，则表示询问当前队列中头部元素是多少。
【输出描述】
对于每一个为"peek"的操作，输出一行表示当前队列中头部元素是多少。
【示例1】
【输入】
6
add 1
add 2
add 3
peek
poll
peek
【输出】
1
2
 */
public class CodeInterviewGuide6 {
    public static void main(String[] args) throws IOException {
        queue1 que = new queue1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("add")){
                que.add(Integer.parseInt(s[1]));
            }else if(s[0].equals("poll")){
                que.poll();
            }else if(s[0].equals("peek")){
                System.out.println(que.peek());
            }
        }
    }
}

class queue1
{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void add(int value){
        stack1.push(value);
    }

    public void poll(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }
    public int peek(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}
