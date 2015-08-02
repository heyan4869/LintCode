package Solution;

public class CoinsInALine {
	public static boolean firstWillWin(int n) {
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return true;
		}
		boolean[] dp = new boolean[n + 1];
		dp[0] = false;
		dp[1] = true;
		for (int i = 2; i <= n; i++) {
			dp[i] = !dp[i - 2] || !dp[i - 1];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstWillWin(0));
	}

}
