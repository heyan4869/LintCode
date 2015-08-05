package Solution;

public class HashFunction {
	public static int hashCode(char[] key, int HASH_SIZE) {
		// use int could overflow
		long sum = (int) key[0];
		for (int i = 1; i < key.length; i++) {
			sum = sum * 33 % HASH_SIZE + (int) key[i];
		}
		return (int) (sum % HASH_SIZE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ubuntu";
		char[] key = str.toCharArray();
		System.out.println(hashCode(key, 1007));
	}

}
