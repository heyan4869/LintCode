package Solution;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII {
	public static int singleNumberII(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		Map<Integer, Integer> hs = new HashMap<Integer, Integer>();
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			if (!hs.containsKey(A[i])) {
				hs.put(A[i], 1);
				res = res ^ A[i];
			} else if (hs.containsKey(A[i]) && hs.get(A[i]) == 1) {
				hs.put(A[i], 2);
				res = res ^ A[i];
			} else {
				continue;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,2,3,3,3,2,2,4,1};
		System.out.println(singleNumberII(A));
	}

}
