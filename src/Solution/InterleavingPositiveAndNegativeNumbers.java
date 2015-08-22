package Solution;

public class InterleavingPositiveAndNegativeNumbers {
	public static void rerange(int[] A) {
		if (A == null || A.length <= 2) {
			return;
		}
		assist(A, -1);
	}

	private static void assist(int[] A, int sign) {
		// check the sign first
		if (A[0] * sign < 0) {
			int p = 1;
			while (A[p] * sign < 0) {
				p++;
			}
			int cur = A[0];
			A[0] = A[p];
			A[p] = cur;
		}
		int p1 = 0;
		int p2 = 1;
		while (p1 < A.length && p2 < A.length) {
			if ((A[p1] < 0 && A[p2] > 0) || (A[p1] > 0 && A[p2] < 0)) {
				p1++;
				p2++;
			} else {
				int p3 = p2;
				while (p3 < A.length
						&& ((A[p1] < 0 && A[p3] < 0) || (A[p1] > 0 && A[p3] > 0))) {
					p3++;
				}
				if (p3 >= A.length) {
					assist(A, 1);
					return;
				}
				int cur = A[p2];
				A[p2] = A[p3];
				A[p3] = cur;
				p1++;
				p2++;
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 3, -1, -2};
		rerange(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + "  ");
		}
	}

}
