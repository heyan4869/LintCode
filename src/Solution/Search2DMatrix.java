package Solution;

public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int row = findRow(matrix, target, 0, matrix.length - 1);
		if (row == -1) {
			return false;
		} else {
			return findCol(matrix[row], target, 0, matrix[0].length - 1);
		}
	}

	private static int findRow(int[][] matrix, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (target >= matrix[mid][0]
				&& target <= matrix[mid][matrix[0].length - 1]) {
			return mid;
		}
		if (target < matrix[mid][0]) {
			return findRow(matrix, target, start, mid - 1);
		}
		if (target > matrix[mid][matrix[0].length - 1]) {
			return findRow(matrix, target, mid + 1, end);
		}
		return -1;
	}
	
	private static boolean findCol(int[] m, int target, int start, int end) {
		if (start > end) {
			return false;
		}
		int mid = (start + end) / 2;
		if (m[mid] == target) {
			return true;
		}
		if (m[mid] > target) {
			return findCol(m, target, start, mid - 1);

		}
		if (m[mid] < target) {
			return findCol(m, target, mid + 1, end);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		System.out.println(searchMatrix(matrix, 8));
	}

}
