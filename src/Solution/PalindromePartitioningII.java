// tricky

package Solution;

import java.util.Arrays;

public class PalindromePartitioningII {
	public static int minCut(String s) {
		int n = s.length();
		if (n <= 1)
			return 0;
		boolean[][] isPal = new boolean[n][n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if ((i + 1 > j - 1 || isPal[i + 1][j - 1])
						&& s.charAt(i) == s.charAt(j))
					isPal[i][j] = true;
			}
		}
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = -1;
		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (isPal[j][i - 1]) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("ABA"));
	}

}
