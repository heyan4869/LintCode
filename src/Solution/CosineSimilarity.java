package Solution;

public class CosineSimilarity {
	public static double cosineSimilarity(int[] A, int[] B) {
		if (A == null || B == null || A.length == 0 || B.length == 0
				|| A.length != B.length) {
			return 2.0000;
		}
		double pow2A = pow2(A);
		double pow2B = pow2(B);
		if (pow2A == 0 || pow2B == 0) {
			return 2.0000;
		}
		return multi(A, B) / (Math.sqrt(pow2A) * Math.sqrt(pow2B));
	}
	
	private static double multi(int[] A, int[] B) {
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			res += A[i] * B[i];
		}
		return res;
	}

	private static double pow2(int[] arr) {
		double res = 0;
		for (int i = 0; i < arr.length; i++) {
			res += Math.pow(arr[i], 2.0);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 2, 3 };
		int[] B = { 2, 3, 4 };
		System.out.println(cosineSimilarity(A, B));
	}

}
