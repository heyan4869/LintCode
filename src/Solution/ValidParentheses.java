package Solution;

import java.util.Stack;

public class ValidParentheses {
	public static boolean isValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				st.push(s.charAt(i));
			} else {
				if (st.isEmpty() || (!(s.charAt(i) == ')' && st.pop() == '(')
						&& !(s.charAt(i) == ']' && st.pop() == '[')
						&& !(s.charAt(i) == '}' && st.pop() == '{'))) {
					return false;
				}
			}
		}
		if (st.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValidParentheses("[]"));
	}

}
