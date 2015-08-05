package Solution;

public class RemoveElement {
	public static int removeElement(int[] A, int elem) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int head = 0;
		int tail = A.length - 1;
		while (head <= tail) {
			while (tail >= 0 && A[tail] == elem) {
				tail--;
			}
			// check if tail is less than 0 already
			if (tail < 0) {
				break;
			}
			if (A[head] != elem) {
				head++;
			} else {
				A[head] = A[tail];
				A[tail] = elem;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		int[] A = {4, 4, 4, 4};
		System.out.println(removeElement(A, 4));
	}

}
