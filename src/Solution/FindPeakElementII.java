package Solution;

import java.util.ArrayList;
import java.util.List;

public class FindPeakElementII {
	public static List<Integer> findPeakII(int[][] A) {
		if (A == null || A.length == 0) {
			return null;
		}
		return assist(A, A.length / 2, A[0].length / 2);
	}

	private static List<Integer> assist(int[][] A, int row, int col) {
		if (row <= 0 || row >= A.length - 1 || col <= 0
				|| col >= A[0].length - 1) {
			return null;
		}
		if (A[row][col] > A[row - 1][col] && A[row][col] > A[row + 1][col]
				&& A[row][col] > A[row][col - 1] && A[row][col] > A[row][col + 1]) {
			List<Integer> res = new ArrayList<Integer>();
			res.add(row);
			res.add(col);
			return res;
		}
		if (A[row][col] < A[row - 1][col]) {
			return assist(A, row - 1, col);
		}
		if (A[row][col] < A[row + 1][col]) {
			return assist(A, row + 1, col);
		}
		if (A[row][col] < A[row][col - 1]) {
			return assist(A, row, col - 1);
		}
		if (A[row][col] < A[row][col + 1]) {
			return assist(A, row, col + 1);
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 1, 2, 3, 6, 5 }, 
				      { 16, 41, 23, 22, 6 },
				      { 15, 17, 24, 21, 7 }, 
				      { 14, 18, 25, 26, 10 },
				      { 13, 14, 11, 10, 9 } };
		List<Integer> res = findPeakII(A);
		System.out.println(res.get(0) + " - " + res.get(1));
	}
}
