// trikcy

package Solution;

public class TwoStringsAreAnagrams {
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] asciitable = new int[256];
		for (int i = s.length() - 1; i >= 0; i--) {
			asciitable[s.charAt(i)]++;
		}
		for (int j = t.length() - 1; j >= 0; j--) {
			char cur = t.charAt(j);
			if (asciitable[cur] == 0) {
				return false;
			}
			asciitable[cur]--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(anagram("acbd", "dcba"));
	}

}
