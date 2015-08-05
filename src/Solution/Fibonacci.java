package Solution;

public class Fibonacci {
	public static int fibonacci(int n) {
		if (n <= 2) {
			return n - 1;
		}
		int[] dp = new int[n];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(10));
	}

}
