package Solution;

import java.util.ArrayList;
import java.util.List;

public class PrintNumbersByRecursion {
	public static List<Integer> numbersByRecursion(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n >= 0) {
			sub(n, res);
		}
		return res;
	}

	private static int sub(int n, List<Integer> res) {
		if (n == 0) {
			return 1;
		}
		int base = sub(n - 1, res);
		for (int i = 1; i <= 9; i++) {
			int curBase = i * base;
			res.add(curBase);
			for (int j = 0; j < res.size(); j++) {
				res.add(curBase + res.get(j));
			}
		}
		return base * 10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
