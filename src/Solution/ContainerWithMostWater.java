package Solution;

public class ContainerWithMostWater {
	public static int maxArea(int[] heights) {
		if (heights == null || heights.length == 0) {
			return 0;
		}
		int p1 = 0;
		int p2 = heights.length - 1;
		int area = Integer.MIN_VALUE;
		while (p1 < p2) {
			area = Math.max(area, Math.min(heights[p1], heights[p2]) * (p2 - p1));
			if (heights[p1] < heights[p2]) {
				p1++;
			} else {
				p2--;
			}
		}
		return area;
	}

	public static void main(String[] args) {
		int[] h = {1, 3, 2, 1};
		System.out.println(maxArea(h));
	}

}
