// tricky

package Solution;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int start = 0;
		int maxLen = 0;
		// key: letter, value: the number of occurrences
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		int i = 0;
		for (i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (hm.containsKey(c)) {
				hm.put(c, hm.get(c) + 1);
			} else {
				hm.put(c, 1);
				while (hm.size() > k) {
					char startChar = s.charAt(start++);
					int count = hm.get(startChar);
					if (count > 1) {
						hm.put(startChar, count - 1);
					} else {
						hm.remove(startChar);
					}
				}
			}
			maxLen = Math.max(maxLen, i - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
