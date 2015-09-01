// tricky

package Solution;

public class Backpack {
	public static int backPack(int m, int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int maxVal = 0;
		int[] dp = new int[m + 1];
		dp[0] = 0;
		if (A[0] < m) {
			dp[A[0]] = 1;
		}
		for (int i = 2; i < A.length + 1; i++) {
			if (A[i - 1] <= m) {
				for (int j = dp.length - 1; j >= 0; j--) {
					if (dp[j] == 1 && j + A[i- 1] <= m) {
						dp[j + A[i - 1]] = 1;
					}
				}
				dp[A[i - 1]] = 1;
			}
		}
		for (int i = dp.length - 1; i >= 0; i--) {
			if (dp[i] == 1) {
				maxVal = i;
				break;
			}
		}
		return maxVal;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 2, 3, 5, 7 };
		System.out.println(backPack(10, A));
	}

}