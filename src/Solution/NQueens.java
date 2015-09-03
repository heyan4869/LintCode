package Solution;

import java.util.ArrayList;

public class NQueens {
	public static ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (n == 0) {
			return res;
		}
		ArrayList<String> temp = new ArrayList<String>();
		int[][] flag = new int[n][n];
		assist(n, 0, res, temp, flag);
		return res;
    }
	
	private static void assist(int n, int currow, ArrayList<ArrayList<String>> res,
			ArrayList<String> temp, int[][] flag) {
		if (currow == n && !res.contains(temp)) {
			res.add(new ArrayList<String>(temp));
		}
		// row is determined by currow
		for (int j = 0; j < n; j++) {
			if (check(currow, j, flag)) {
				flag[currow][j] = 1;
				temp.add(getRow(j, n));
				assist(n, currow + 1, res, temp, flag);
				flag[currow][j] = 0;
				temp.remove(temp.size() - 1);
			}
		}
	}

	private static String getRow(int j, int n) {
		String res = "";
		for (int i = 0; i < n; i++) {
			if (i == j) {
				res += "Q";
			} else {
				res += ".";
			}
		}
		return res;
	}

	private static boolean check(int row, int col, int[][] flag) {
		for (int i = 0; i < flag.length; i++) {
			for (int j = 0; j < flag.length; j++) {
				if (i == row && flag[i][j] == 1)
					return false;
				if (j == col && flag[i][j] == 1)
					return false;
				if ((Math.abs(row - i) == Math.abs(col - j))
						&& (flag[i][j] == 1))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
