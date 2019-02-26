package algorithm.tree;

import java.util.Stack;

/**
 * Author: 小栗旬
 * Date: 2019/2/17 22:51
 */
public class TraversalStack {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		TraversalStack traversalStack = new TraversalStack();
		traversalStack.theFirstTraversalStack(root);
//		solution.theInOrderTraversalStack(root);
	}

	void theFirstTraversalStack(Node root) {
		Stack<Node> stack = new Stack<>();
		Node node = root;
		stack.push(node);

		while (!stack.isEmpty()) {
			node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			System.out.println(node.value);
		}
	}

	void theInOrderTraversalStack(Node root) {
		Stack<Node> stack = new Stack<>();
		Node node = root;

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.println(node.value);
				node = node.right;
			}

		}
	}

	void thePostOrderTraversalStack(Node root) {
		Stack<Node> stack = new Stack<>();
		Stack<Node> output = new Stack<>();
		Node node = root;

		while (node != null || !stack.isEmpty()) {
			if (node != null) {
				output.push(node);
				stack.push(node);
				node = node.right;
			} else {
				node = stack.pop();
				node = node.left;
			}
		}

		while (!output.isEmpty()) {
			System.out.println(output.pop().value);
		}

	}

}


class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
	}
}

