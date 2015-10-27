// tricky

package Solution;

import java.util.Stack;

public class LargestRectangleHistogram {
	public static int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int cur = (i == len ? 0 : height[i]);
			if (s.isEmpty() || cur >= height[s.peek()]) {
				s.push(i);
			} else {
				int temp = s.pop();
				maxArea = Math.max(maxArea, height[temp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(height));
	}

}
