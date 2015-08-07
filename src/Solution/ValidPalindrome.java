package Solution;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return true;
		}
		int head = 0;
		int tail = s.length() - 1;
		while (head <= tail) {
			while (head < s.length() && !isAlpha(s.charAt(head))) {
				head++;
			}
			while (tail >= 0 && !isAlpha(s.charAt(tail))) {
				tail--;
			}
			// since only consider alphanumeric characters
			if (head >= s.length() || tail < 0) {
				return true;
			}
			if (s.charAt(head) == s.charAt(tail)
					|| s.charAt(head) == s.charAt(tail) + 32
					|| s.charAt(head) == s.charAt(tail) - 32) {
				head++;
				tail--;
			} else {
				return false;
			}
		}
		return true;
	}

	private static boolean isAlpha(char c) {
		if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90)
				|| (c >= 97 && c <= 122)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(".,"));
	}

}
