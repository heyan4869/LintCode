package Solution;

public class CountOnesInBinary {
	public static int countOnes(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
        	if (((num >> i) & 1) == 1) {
        		count++;
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countOnes(5));
	}

}
