// tricky

package Solution;

public class PalindromePartitioningII {
	public static int minCut(String s) {
		int len = s.length();
		// store the num of cut
		int[] d = new int[len + 1];
		// store whether palindrome between i and j
		boolean[][] p = new boolean[len][len];
		// the worst case is cutting by each char
		for (int i = 0; i <= len; i++)
			d[i] = len - i;
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				p[i][j] = false;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					d[i] = Math.min(d[i], d[j + 1] + 1);
				}
			}
		}
		return d[0] - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
