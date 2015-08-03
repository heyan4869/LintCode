package Solution;

import java.util.Arrays;

public class TheSmallestDifference {
	public static int smallestDifference(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int pa = 0;
		int pb = 0;
		int minDiff = Integer.MAX_VALUE;
		while (pa < A.length && pb < B.length) {
			if (A[pa] == B[pb]) {
				return 0;
			} else if (A[pa] < B[pb]) {
				minDiff = Math.min(minDiff, B[pb] - A[pa]);
				pa++;
			} else {
				minDiff = Math.min(minDiff, A[pa] - B[pb]);
				pb++;
			}
		}
		return minDiff;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, 6, 7, 4 };
		int[] B = { 2, 8, 9, 5 };
		System.out.println(smallestDifference(A, B));
	}

}
