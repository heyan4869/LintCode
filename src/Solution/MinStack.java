package Solution;

import java.util.Stack;

public class MinStack {
	public static Stack<Integer> num = new Stack<Integer>();
	public static Stack<Integer> min = new Stack<Integer>();

    public static void push(int number) {
        // write your code here
    	if (min.isEmpty() || number <= min.peek()) {
    		min.push(number);
    	}
    	num.push(number);
    }

    public static int pop() {
        // use .equals to compare if same element
    	if (num.peek().equals(min.peek())) {
    		min.pop();
    	}
    	return num.pop();
    }

    public static int min() {
        // write your code here
    	return min.peek();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
