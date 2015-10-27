package Solution;

public class QuickSort {
	public static void qs(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0 || low >= high) {
			return;
		}
		// pick the pivot
		int mid = low + (high - low) / 2;
		int pivot = arr[mid];
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		// recursively sort two sub parts
		quickSort(arr, low, j);
		quickSort(arr, i, high);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 10, 4, 2, 3, 1, 5 };
		qs(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
