package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchForRange {
	public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int start = findStart(A, target, 0, A.size() - 1);
		int end = findEnd(A, target, 0, A.size() - 1);
		res.add(start);
		res.add(end);
		return res;
	}
	
	private static int findStart(ArrayList<Integer> A, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if ((A.get(mid) == target && mid == start) || (A.get(mid) == target && A.get(mid - 1) < target)) {
			return mid;
		}
		if (A.get(mid) >= target) {
			return findStart(A, target, start, mid - 1);
		}
		if (A.get(mid) < target) {
			return findStart(A, target, mid + 1, end);
		}
		return -1;
	}
	
	private static int findEnd(ArrayList<Integer> A, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end) / 2;
		if ((A.get(mid) == target && mid == end) || (A.get(mid) == target && A.get(mid + 1) > target)) {
			return mid;
		}
		if (A.get(mid) > target) {
			return findEnd(A, target, start, mid - 1);
		}
		if (A.get(mid) <= target) {
			return findEnd(A, target, mid + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(5, 8, 8, 8, 8, 10));
		ArrayList<Integer> res = searchRange(A, 8);
		System.out.println(res.get(0) + " - " + res.get(1));
	}

}
