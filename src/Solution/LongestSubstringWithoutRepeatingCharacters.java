// tricky

package Solution;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		int len = s.length();
		char[] array = s.toCharArray();
		int start = 0, end = 0, maxLen = 1;
		Set<Character> hs = new HashSet<Character>();
		while (end < len) {
			if (!hs.add(array[end])) {
				if ((end - start) > maxLen) {
					maxLen = end - start;
				}
				while (!hs.add(array[end])) {
					hs.remove(array[start]);
					start++;
				}
			}
			end++;
		}
		return maxLen > (end - start) ? maxLen : (end - start);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "an++--viaj";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
