package Solution;

public class MaximalSquare {
	public static int maxSquare(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int[][] dp = new int[matrix.length][matrix[0].length];
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 1) {
				dp[i][0] = 1;
				maxArea = Math.max(maxArea, 1);
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (matrix[0][j] == 1) {
				dp[0][j] = 1;
				maxArea = Math.max(maxArea, 1);
			}
		}
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					if (matrix[i - 1][j] > 0 && matrix[i][j - 1] > 0
							&& matrix[i - 1][j - 1] > 0) {
						dp[i][j] = (int) Math.pow(Math.sqrt(Math.min(
								Math.min(dp[i - 1][j], dp[i][j - 1]),
								dp[i - 1][j - 1])) + 1, 2);
						maxArea = Math.max(maxArea, dp[i][j]);
					} else {
						dp[i][j] = 1;
						maxArea = Math.max(maxArea, dp[i][j]);
					}
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 } };
		System.out.println(maxSquare(matrix));
	}

}
