package Solution;

public class RotateString {
	public static void rotateString(char[] str, int offset) {
		if (str == null || str.length == 0) {
			return;
		}
		int count = offset % str.length;
		if (count == 0) {
			return;
		}
		while (count != 0) {
			char temp = str[str.length - 1];
			for (int i = str.length - 2; i >= 0; i--) {
				str[i + 1] = str[i];
			}
			str[0] = temp;
			count--;
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = { 'a', 'b', 'c', 'd' };
		rotateString(str, 1);
		for (int i = 0; i < str.length; i++) {
			System.out.print(" " + str[i] + " ");
		}
	}

}
