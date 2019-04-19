package algorithm.JianZhiOffer;

import java.util.Stack;

/**
 * Author: 小栗旬
 * Date: 2019/4/19 17:49
 */
public class QueueByStack {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		while (!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		stack1.push(node);
	}

	public int pop() {
		while (!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	public static void main(String[] args) {
//		QueueByStack solution = new QueueByStack();
//		System.out.println(solution.pop());
//		solution.push(1);
//		solution.push(2);
//		solution.push(3);
//		System.out.println(solution.pop());
//		solution.push(4);
//		System.out.println(solution.pop());
		Stack<Integer> stack = new Stack<>();
		System.out.println(stack.pop());
	}
}
