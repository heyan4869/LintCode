package Solution;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> arr = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			arr.add(i);
		}
		assist(0, res, arr, temp, k);
		return res;
	}

	private static void assist(int pre, List<List<Integer>> res,
			List<Integer> arr, List<Integer> temp, int k) {
		if (temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = 0; i < arr.size(); i++) {
			int curr = arr.get(i);
			if (curr > pre) {
				arr.remove(i);
				temp.add(curr);
				assist(curr, res, arr, temp, k);
				temp.remove(Integer.valueOf(curr));
				arr.add(i, curr);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
