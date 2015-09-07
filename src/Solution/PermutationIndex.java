// tricky

package Solution;

public class PermutationIndex {
	public static long permutationIndex(int[] A) {
		long index = 0;
		// position 1 is paired with factor 0 and so is skipped
		long position = 2;
		long factor = 1;
		for (int p = A.length - 2; p >= 0; p--) {
			int successors = 0;
			for (int q = p + 1; q < A.length; q++) {
				if (A[p] > A[q]) {
					successors++;
				}
			}
			index += (successors * factor);
			factor *= position;
			position++;
		}
		return index + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 4,2};
		System.out.println(permutationIndex(A));
	}

}
