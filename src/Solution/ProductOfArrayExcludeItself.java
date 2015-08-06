package Solution;

import java.util.ArrayList;

public class ProductOfArrayExcludeItself {
	public static ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
		ArrayList<Long> res = new ArrayList<>();
		long temp = 1;
		for (int i = 0; i < A.size(); i++) {
			res.add(temp);
			temp = temp * A.get(i);
		}
		temp = 1;
		for (int i = A.size() - 1; i >= 0; i--) {
			long cur = res.get(i);
			res.remove(i);
			res.add(i, cur * temp);
			temp = temp * A.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<>();
		A.add(4);
		A.add(5);
		A.add(6);
		A.add(7);
		ArrayList<Long> res = productExcludeItself(A);
		for (int i = 0; i < A.size(); i++) {
			System.out.print(" " + res.get(i) + " ");
		}
	}

}
