package Solution;

import java.util.Arrays;

public class CompareStrings {
	public static boolean compareStrings(String A, String B) {
		if ((A == null || A.length() == 0) && (B.length() != 0)) {
			return false;
		}
		if (B == null || B.length() == 0) {
			return true;
		}
		char[] ca = A.toCharArray();
		Arrays.sort(ca);
		char[] cb = B.toCharArray();
		Arrays.sort(cb);
		int pa = 0;
		int pb = 0;
		while (pa < ca.length && pb < cb.length) {
			if (ca[pa] == cb[pb]) {
				pa++;
				pb++;
			} else {
				while (pa < ca.length && ca[pa] != cb[pb]) {
					pa++;
				}
				if (pa < ca.length && ca[pa] == cb[pb]) {
					pa++;
					pb++;
				} else {
					return false;
				}
			}
		}
		if (pb < cb.length) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compareStrings("AAAAAAAAAABBBAAAAAAAAA",
				"BBBBAAAAAAAAA"));
	}

}
