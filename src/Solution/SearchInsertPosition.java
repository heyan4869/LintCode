package Solution;

public class SearchInsertPosition {
	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		for (int i = 0; i < A.length; i++) {
			if (target <= A[i]) {
				return i;
			}
		}
		return A.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,6};
		System.out.println(searchInsert(A, 7));
	}

}
