package Solution;

public class CheckPowerOf2 {
	public static boolean checkPowerOf2(int n) {
		if (n < 1) {
			return false;
		}
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) == (1 << i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPowerOf2(3));
	}

}
