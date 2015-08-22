package Solution;

public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {
		if (s == null || s.length() <= 2) {
			return s;
		}
		String res = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (i + (i - j) + 2 <= s.length() && assist(s.substring(j, i + (i - j) + 2))) {
					if (s.substring(j, i + (i - j) + 2).length() > res.length()) {
						res = s.substring(j, i + (i - j) + 2);
					}
				}
				if (i + (i - j) + 1 <= s.length() && assist(s.substring(j, i + (i - j) + 1))) {
					if (s.substring(j, i + (i - j) + 1).length() > res.length()) {
						res = s.substring(j, i + (i - j) + 1);
					}
				}
			}
		}
		return res;
	}
	
	private static boolean assist(String str) {
		if (str == null || str.length() == 0 || str.length() == 1) {
			return true;
		}
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("caba"));
		// System.out.println(assist("aa"));
	}

}
