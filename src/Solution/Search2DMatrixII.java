package Solution;

public class Search2DMatrixII {
	private static int res = 0;

	public static int searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		assist(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
		return res;
	}

	private static void assist(int[][] matrix, int target, int uprow,
			int upcol, int downrow, int downcol) {
		if (uprow > downrow || upcol > downcol || target < matrix[uprow][upcol]
				|| target > matrix[downrow][downcol]) {
			return;
		}
		int midrow = (uprow + downrow) / 2;
		int midcol = (upcol + downcol) / 2;
		if (target == matrix[midrow][midcol]) {
			count();
			assist(matrix, target, uprow, midcol + 1, midrow, downcol);
			assist(matrix, target, midrow + 1, upcol, downrow, midcol);
			assist(matrix, target, midrow + 1, midcol + 1, downrow, downcol);
			return;
		} else if (target < matrix[midrow][midcol]) {
			assist(matrix, target, uprow, upcol, midrow, midcol);
			assist(matrix, target, uprow, midcol + 1, midrow, downcol);
			assist(matrix, target, midrow + 1, upcol, downrow, midcol);
			return;
		} else {
			assist(matrix, target, midrow + 1, midcol + 1, downrow, downcol);
			assist(matrix, target, uprow, midcol + 1, midrow, downcol);
			assist(matrix, target, midrow + 1, upcol, downrow, midcol);
			return;
		}
	}

	private static void count() {
		res++;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = new int[][] {
				{ 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 },
				{ 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81 },
				{ 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82 },
				{ 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83 },
				{ 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84 },
				{ 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85 } };

		System.out.println(searchMatrix(m, 81));
	}
}
