package Solution;

import java.util.PriorityQueue;

public class MedianOfTwoSortedArray {
	public static double findMedianSortedArrays(int[] A, int[] B) {
		if (A.length == 0 && B.length == 0) {
			return 0;
		}
		boolean even = (A.length + B.length) % 2 == 0 ? true : false;
		int mid = (A.length + B.length) / 2;
		double res = 0;
		int tailA = A.length - 1;
		int tailB = B.length - 1;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		while (mid >= 0) {
			if (tailA < 0) {
				maxHeap.add(B[tailB]);
				tailB--;
			} else if (tailB < 0) {
				maxHeap.add(A[tailA]);
				tailA--;
			} else if (A[tailA] > B[tailB]) {
				maxHeap.add(A[tailA]);
				tailA--;
			} else {
				maxHeap.add(B[tailB]);
				tailB--;
			}
			mid--;
		}
		res = maxHeap.poll();
		if (even) {
			res = (res + maxHeap.poll()) / 2.0;
		}
		return res;
	}

	public static void main(String[] args) {
		// 1, 2, 3, 4, 4, 5, 6
		int[] A = { 1 };
		int[] B = {  };
		System.out.println(findMedianSortedArrays(A, B));
	}
}
