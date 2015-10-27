package Solution;

import java.util.Stack;

public class ExpressionEvaluation {
	public static int evaluateExpression(String[] expression) {
		if (expression == null || expression.length == 0) {
			return -1;
		}
		Stack<Integer> num = new Stack<>();
		Stack<String> sym = new Stack<>();
		int idx = 0;
		while (idx < expression.length) {
			String cur = expression[idx];
			if (!checkSym(cur)) {
				num.push(Integer.valueOf(cur));
			} else {
				if (cur.equals("(")) {
					sym.push(cur);
				} else if (cur.equals(")")){
					while (!sym.peek().equals("(")) {
						num.push(calculate(num.pop(), num.pop(), sym.pop()));
					}
					sym.pop();
				} else {
					while (!sym.isEmpty() && preceed(cur, sym.peek())) {
						num.push(calculate(num.pop(), num.pop(), sym.pop()));
					}
					sym.push(cur);
				}
			}
			idx++;
		}
		while (!sym.isEmpty()) {
			num.push(calculate(num.pop(), num.pop(), sym.pop()));
		}
		return num.isEmpty() ? 0 : num.pop();
	}
	
	private static boolean preceed(String cur, String pre) {
		if (pre.equals("*") || pre.equals("/")) {
			return true;
		}
		if (pre.equals("+") || pre.equals("-")) {
			if (cur.equals("*") || cur.equals("/")) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private static int calculate(int a, int b, String symbol) {
		if (symbol.equals("+")) {
			return a + b;
		} else if (symbol.equals("-")) {
			return b - a;
		} else if (symbol.equals("*")) {
			return a * b;
		} else {
			return b / a;
		}
	}

	private static boolean checkSym(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*")
				|| str.equals("/") || str.equals("(") || str.equals(")")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] exp = { "2", "*", "6", "-", "(", "23", "+", "7", ")", "/",
				"(", "1", "+", "2", ")" };
		System.out.println(evaluateExpression(exp));
	}
}
