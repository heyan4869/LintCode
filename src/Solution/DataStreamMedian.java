package Solution;

import java.util.PriorityQueue;

public class DataStreamMedian {
	public static int[] medianII(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int[] res = new int[nums.length];
		int median = nums[0];
		res[0] = median;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > median) {
				maxHeap.add(nums[i]);
			} else {
				minHeap.add(-nums[i]);
			}
			if (maxHeap.size() < minHeap.size()) {
				maxHeap.add(median);
				median = -minHeap.poll();
			} else if (maxHeap.size() > minHeap.size() + 1) {
				minHeap.add(-median);
				median = maxHeap.poll();
			}
			res[i] = median;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 20, 100 };
		int[] res = medianII(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

}
