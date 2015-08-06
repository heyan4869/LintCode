package Solution;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		if (s == null || s.length() == 0) {
			res.add(new ArrayList<String>());
			return res;
		}
		assist(s, res, temp, 0, s.length() - 1);
		return res;
	}

	private static void assist(String s, List<List<String>> res,
			List<String> temp, int start, int end) {
		if (check(temp, s)) {
			res.add(new ArrayList<String>(temp));
			return;
		}
		for (int i = start; i <= end; i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				assist(s, res, temp, i + 1, end);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	private static boolean check(List<String> temp, String s) {
		String cur = "";
		for (int i = 0; i < temp.size(); i++) {
			cur += temp.get(i);
		}
		if (cur.equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isPalindrome(String str, int l, int r) {
		if (l == r) {
			return true;
		}
		while (l < r) {
			if (str.charAt(l) != str.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
