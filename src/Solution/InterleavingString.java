// tricky

package Solution;

public class InterleavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		boolean[][] record = new boolean[s1.length() + 1][s2.length() + 1];
		// substring(0, i) does not contains ith char
		for (int i = 0; i <= s1.length(); i++) {
			if (s1.substring(0, i).equals(s3.substring(0, i))) {
				record[i][0] = true;
			}
		}
		for (int j = 0; j <= s2.length(); j++) {
			if (s2.substring(0, j).equals(s3.substring(0, j))) {
				record[0][j] = true;
			}
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (record[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
					record[i][j] = true;
				if (record[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
					record[i][j] = true;
			}
		}
		return record[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleave(s1, s2, s3));
	}

}
