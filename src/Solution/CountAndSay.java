package Solution;

public class CountAndSay {
	public static String countAndSay(int n) {
		if (n == 0) {
			return "";
		} else if (n == 1) {
			return "1";
		} else {
			return assist("1", n - 1);
		}
	}

	private static String assist(String res, int n) {
		if (n == 0) {
			return res;
		}
		String temp = "";
		char cur = res.charAt(0);
		int count = 1;
		for (int i = 1; i < res.length(); i++) {
			if (res.charAt(i) == cur) {
				count++;
			} else {
				temp = temp + count + cur;
				cur = res.charAt(i);
				count = 1;
			}
		}
		temp = temp + count + cur;
		return assist(temp, n - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
