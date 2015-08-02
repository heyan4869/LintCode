package Solution;

public class ABProblem {
	public static int aplusb(int a, int b) {
		int res = 0;
		int carry = 0;
        for (int i = 0; i < 32; i++) {
        	int temp = ((a >> i) & 1) + ((b >> i) & 1) + carry;
        	if (temp == 0) {
        		carry = 0;
        	} else if (temp == 1) {
        		res = (1 << i) | res;
        		carry = 0;
        	} else if (temp == 2) {
        		carry = 1;
        	} else {
        		res = (1 << i) | res;
        		carry = 1;
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(aplusb(5, 3));
		// System.out.println((3 >> 0) & 1 + (5 >> 0) & 1);
	}

}
