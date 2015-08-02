package Solution;

public class FindPeakElement {
	public static int findPeak(int[] A) {
		return helper(A, 0, A.length - 1);
	}

	private static int helper(int[] a, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if ((mid == 0 || a[mid - 1] < a[mid])
				&& (mid == a.length - 1 || a[mid] > a[mid + 1])) {
			return mid;
		}
		if (a[mid] < a[mid + 1]) {
			return helper(a, mid + 1, high);
		} else {
			return helper(a, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
