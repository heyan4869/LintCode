package Solution;

import java.util.Stack;

public class ImplementQueueByTwoStacks {
	private static Stack<Integer> stack1;
	private static Stack<Integer> stack2;

	public static void Solution() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public static void push(int element) {
		if (stack2.isEmpty()) {
			stack2.push(element);
		} else {
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			stack2.push(element);
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
	}

	public static int pop() {
		return stack2.pop();
	}

	public static int top() {
		return stack2.peek();
	}
	
	public static void main(String[] args) {
		Solution();
		push(1);
		System.out.println(pop());
		push(2);
		push(3);
		System.out.println(top());
		System.out.println(pop());
	}
}
