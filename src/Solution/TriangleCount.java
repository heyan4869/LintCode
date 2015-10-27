package Solution;

import java.util.Arrays;

public class TriangleCount {
	public static int triangleCount(int[] S) {
		if (S == null || S.length == 0) {
			return 0;
		}
		int res = 0;
		Arrays.sort(S);
		// start from the end of S
		for (int i = S.length - 1; i > 0; i--) {
			int head = 0;
			int tail = i - 1;
			while (head < tail) {
				if (S[i] < S[head] + S[tail]) {
					res += tail - head;
					tail--;
				} else {
					head++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = { 3, 4, 6, 7 };
		System.out.println(triangleCount(S));
	}

}
