package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] candidates,
			int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if (candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		assist(candidates, target, 0, 0, temp, res);
		return res;
	}

	private static void assist(int[] candidates, int target, int start,
			int preSum, List<Integer> temp, List<List<Integer>> res) {
		if (preSum > target) {
			return;
		}
		if (preSum == target) {
			// Collections.sort(temp);
			if (res.contains(temp)) {
				return;
			} else {
				res.add(new ArrayList<Integer>(temp));
				return;
			}
		}
		for (int i = start; i < candidates.length; i++) {
			preSum += candidates[i];
			temp.add(candidates[i]);
			assist(candidates, target, i + 1, preSum, temp, res);
			preSum -= candidates[i];
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
