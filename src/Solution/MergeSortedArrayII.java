package Solution;

import java.util.ArrayList;

public class MergeSortedArrayII {
	public static ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A,
			ArrayList<Integer> B) {
		if (A.size() < B.size()) {
			return mergeSortedArray(B, A);
		}
		int pa = 0;
		int pb = 0;
		int cur = 0;
		while (pa < A.size() && pb < B.size()) {
			if (A.get(pa) <= B.get(pb)) {
				pa++;
				cur++;
			} else {
				A.add(cur, B.get(pb));
				pa++;
				pb++;
				if (pb < B.size()) {
					cur++;
				}
			}
		}
		while (pb < B.size()) {
			A.add(cur, B.get(pb));
			pb++;
			cur++;
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		A.add(1);
		A.add(5);
//		A.add(3);
//		A.add(4);
		B.add(2);
		B.add(4);
//		B.add(5);
//		B.add(6);
		ArrayList<Integer> res = mergeSortedArray(A, B);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}
	}

}
