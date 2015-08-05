// tricky!

package Solution;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
	public static List<Integer> singleNumberIII(int[] A) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			res = res ^ A[i];
		}
		// C - (C - 1) & C get the last digit 1
		int lastOneVal = res - (res & (res - 1));
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		// seperate the two different number
		for (int i = 0; i < A.length; i++) {
			if ((A[i] & lastOneVal) == lastOneVal) {
				l1.add(A[i]);
			} else {
				l2.add(A[i]);
			}
		}
		int ret1 = 0;
		int ret2 = 0;
		for (int i = 0; i < l1.size(); i++) {
			ret1 = ret1 ^ l1.get(i);
		}
		for (int j = 0; j < l2.size(); j++) {
			ret2 = ret2 ^ l2.get(j);
		}
		List<Integer> single = new ArrayList<Integer>();
		single.add(ret1);
		single.add(ret2);
		return single;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 2, 3, 4, 4, 11, 3 };
		List<Integer> single = singleNumberIII(A);
		System.out.println(single.get(0));
		System.out.println(single.get(1));
	}

}
