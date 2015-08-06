// tricky

package Solution;

public class NumberOfIslands {
	public static int numIslands(boolean[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j]) {
					marking(grid, i, j, row, col);
					++count;
				}
			}
		}
		return count;
	}

	private static void marking(boolean[][] grid, int i, int j, int row, int col) {
		if (i < 0 || j < 0 || i >= row || j >= col || !grid[i][j]) {
			return;
		}
		grid[i][j] = false;
		marking(grid, i + 1, j, row, col);
		marking(grid, i - 1, j, row, col);
		marking(grid, i, j + 1, row, col);
		marking(grid, i, j - 1, row, col);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] grid = { { true, true, false, false, false },
				{ false, true, false, false, true },
				{ false, false, false, true, true },
				{ false, false, false, false, false },
				{ false, false, false, false, true } };
		System.out.println(numIslands(grid));
	}

}
