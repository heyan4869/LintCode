// tricky

package Solution;

public class Heapify {
	public void heapify(int[] A) {
		for (int i = A.length / 2 - 1; i >= 0; i--) {
			helper(A, i);
		}
	}

	void helper(int[] A, int i) {
		int left = i * 2 + 1 >= A.length ? Integer.MAX_VALUE : A[2 * i + 1];
		int right = i * 2 + 2 >= A.length ? Integer.MAX_VALUE : A[2 * i + 2];

		if (left < right && left < A[i]) {
			A[2 * i + 1] = A[i];
			A[i] = left;
			helper(A, 2 * i + 1);
		} else if (right < A[i]) {
			A[2 * i + 2] = A[i];
			A[i] = right;
			helper(A, 2 * i + 2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
