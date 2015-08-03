package Solution;

public class SortLettersByCase {
	public static void sortLetters(char[] chars) {
		int low = 0;
		int high = chars.length - 1;
		while (low < high) {
			while (low <= chars.length - 1 && chars[low] >= 'a' && chars[low] <= 'z') {
				low++;
			}
			while (high >= 0 && chars[high] >= 'A' && chars[high] <= 'Z') {
				high--;
			}
			if (low < high) {
				swap(chars, low, high);
			}
		}
	}

	private static void swap(char[] chars, int low, int high) {
		char temp = chars[low];
		chars[low] = chars[high];
		chars[high] = temp;	
	}

	public static void main(String[] args) {
		char[] c = {'a', 'c'};
		sortLetters(c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(" - " + c[i] + " - ");
		} 
	}

}
