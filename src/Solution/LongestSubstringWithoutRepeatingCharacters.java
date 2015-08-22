package Solution;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int maxLen = 0;
		int start = 0;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (!hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), i);
				maxLen = Math.max(maxLen, i - start + 1);
			} else {
				start = hm.get(s.charAt(i)) + 1;
				maxLen = Math.max(maxLen, i - start + 1);
				hm.put(s.charAt(i), i);
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "an++--viaj";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
