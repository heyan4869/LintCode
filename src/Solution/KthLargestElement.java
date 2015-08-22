// PriorityQueue

package Solution;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static int kthLargestElement(int k, ArrayList<Integer> numbers) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < numbers.size(); i++) {
			if (queue.size() < k) {
				queue.add(numbers.get(i));
			} else {
				if (numbers.get(i) > queue.peek()) {
					queue.remove();
					queue.add(numbers.get(i));
				}
			}
		}
		return queue.remove();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(5);
		numbers.add(2);
		numbers.add(3);
		System.out.println(kthLargestElement(2, numbers));
	}

}
