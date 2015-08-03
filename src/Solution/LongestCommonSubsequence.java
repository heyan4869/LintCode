// tricky

package Solution;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String A, String B) {
		if (A == null || A.length() == 0) {
			return B.length();
		}
		if (B == null || B.length() == 0) {
			return A.length();
		}
		int[][] dp = new int[A.length()][B.length()];
		for (int i = 0; i < A.length(); i++) {
			for (int j = 0; j < B.length(); j++) {
				if (A.charAt(i) == B.charAt(j)) {
					// can only be determined by dp[i-1][j-1]
					dp[i][j] = assist(dp, i - 1, j - 1) + 1;
				} else {
					dp[i][j] = Math.max(assist(dp, i - 1, j),
							assist(dp, i, j - 1));
				}
			}
		}
		return dp[A.length() - 1][B.length() - 1];
	}

	private static int assist(int[][] dp, int i, int j) {
		if (i >= 0 && j >= 0) {
			return dp[i][j];
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("ACBD", "ABCD"));
	}
}
