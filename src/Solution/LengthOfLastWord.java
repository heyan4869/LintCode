package Solution;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int end = s.length() - 1;
		while (end >= 0) {
			if (s.charAt(end) != ' ') {
				break;
			}
			end--;
		}
		int start = end;
		if (end < 0) {
			return 0;
		} else {
			while (start >= 0) {
				if (s.charAt(start) == ' ') {
					break;
				}
				start--;
			}
		}
		return end - start;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("  Hello  "));
	}

}
