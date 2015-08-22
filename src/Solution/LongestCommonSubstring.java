package Solution;

public class LongestCommonSubstring {
	public static int longestCommonSubstring(String A, String B) {
		int len = 0;
		int[][] dp = new int[A.length()][B.length()];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					dp[i][j] = (i == 0 || j == 0) ? 1 : dp[i - 1][j - 1] + 1;
					if (dp[i][j] > len) {
						len = dp[i][j];
					}
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestCommonSubstring("abacd", "abca"));
	}

}
