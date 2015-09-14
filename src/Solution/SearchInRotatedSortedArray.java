package Solution;

public class SearchInRotatedSortedArray {
	public static int search(int[] A, int target) {
		if (A.length == 0) {
			return -1;
		}
		return assist(A, target, 0, A.length - 1);
	}

	private static int assist(int[] A, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (A[mid] == target) {
			return mid;
		} else if ((target < A[mid] && target >= A[start])
				|| (target >= A[start] && A[mid] < A[start])
				|| (target < A[mid] && A[mid] < A[start])) {
			return assist(A, target, start, mid - 1);
		} else {
			return assist(A, target, mid + 1, end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 0, 1, 2, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1 };
		System.out.println(search(A, -9));
	}

}
