package Solution;

import java.util.Arrays;

public class UniqueCharacters {
	public static boolean isUnique(String str) {
		char[] ca = str.toCharArray();
		Arrays.sort(ca);
		for (int i = 0; i < str.length() - 1; i++) {
			if (ca[i] == ca[i + 1]) {
				return false;
			}
		}
		return true;
    }

	public static void main(String[] args) {
		System.out.println(isUnique("abca"));
	}

}
