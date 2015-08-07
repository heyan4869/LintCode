package Solution;

public class MystrStr {
	public static int strStr(String source, String target) {
		if (source == null || target == null) {
			return -1;
		}
		int l1 = source.length(), l2 = target.length();
		if (l1 < l2) {
			return -1;
		} else if (l2 == 0) {
			return 0;
		}
		int threshold = l1 - l2;
		for (int i = 0; i <= threshold; ++i) {
			if (source.substring(i, i + l2).equals(target)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
