package Solution;

public class SortColorsII {
	public void sortColors2(int[] colors, int k) {
		if (colors == null || colors.length == 0 || k <= 0) {
			return;
		}
		int end = colors.length - 1;
		for (int i = 0; i < k - 1; i++) {
			end = helper(colors, 0, end, k - i - 1);
		}
	}

	public void swap(int[] colors, int x, int y) {
		int temp = colors[x];
		colors[x] = colors[y];
		colors[y] = temp;
	}

	public int helper(int[] colors, int start, int end, int pivot) {
		int low = start;
		int high = end;
		while (low <= high) {
			while (low < high && colors[low] <= pivot) {
				low++;
			}
			while (high > 0 && colors[high] > pivot) {
				high--;
			}
			if (low <= high) {
				swap(colors, low, high);
				low++;
				high--;
			}
		}
		return low - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
