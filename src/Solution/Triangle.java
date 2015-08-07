// tricky

package Solution;

import java.util.ArrayList;

public class Triangle {
	public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int[] dp = new int[triangle.size()];
		
		// put elements of last line in dp
		for (int i = 0; i < triangle.size(); i++) {
			dp[i] = triangle.get(triangle.size() - 1).get(i);
		}
		
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}

		return dp[0];
	}

	// incorrect solution
	public static int minimumTotals(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}
		int[] dp = new int[triangle.size()];
		int cur = 0;
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < triangle.size(); i++) {
			dp[i] = dp[i - 1]
					+ Math.min(triangle.get(i).get(cur),
							triangle.get(i).get(cur + 1));
			if (dp[i] - dp[i - 1] == triangle.get(i).get(cur + 1)) {
				cur++;
			}
		}
		return dp[triangle.size() - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(-1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2);
		l2.add(3);
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		l3.add(1);
		l3.add(-1);
		l3.add(-3);
		// ArrayList<Integer> l4 = new ArrayList<Integer>();
		// l4.add(4);
		// l4.add(1);
		// l4.add(8);
		// l4.add(3);
		tri.add(l1);
		tri.add(l2);
		tri.add(l3);
		// tri.add(l4);
		System.out.println(minimumTotal(tri));
	}

}
