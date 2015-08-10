// could also use segment tree

package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfSmallerNumber {
	// use binary search
	public static ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Arrays.sort(A);
		for (int i = 0; i < queries.length; i++) {
			int cur = assist(A, queries[i], 0, A.length - 1);
			if (cur == -1) {
				res.add(0);
			} else {
				res.add(cur);
			}
		}
		return res;
	}

	private static Integer assist(int[] A, int ele, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (A[mid] >= ele && (mid == 0 || A[mid - 1] < ele)) {
			return mid;
		}
		if (A[mid] >= ele && (mid == 0 || A[mid - 1] >= ele)) {
			return assist(A, ele, start, mid - 1);
		}
		if (A[mid] < ele) {
			return assist(A, ele, mid + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 7, 8, 5 };
		int[] queries = { 1, 8, 5 };
		ArrayList<Integer> res = countOfSmallerNumber(A, queries);
		System.out.println(res);

	}

}
