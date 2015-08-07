package Solution;

public class SpaceReplacement {
	public static int replaceBlank(char[] string, int length) {
		if (string == null || string.length == 0) {
			return 0;
		}
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				for (int j = length - 1; j > i; j--) {
					string[j + 2] = string[j];
				}
				string[i] = '%';
				string[i + 1] = '2';
				string[i + 2] = '0';
				length += 2;
			}
		}
		return length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] string = { 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm',
				'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		int len = replaceBlank(string, 14);
		for (int i = 0; i < len; i++) {
			System.out.print(" " + string[i] + " ");
		}
	}
}
