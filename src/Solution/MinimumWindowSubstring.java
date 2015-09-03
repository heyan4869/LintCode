// tricky

package Solution;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	public static String minWindow(String source, String target) {
		HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
		for (int i = 0; i < target.length(); i++) {
			char c = target.charAt(i);
			if (!dict.containsKey(c)) {
				dict.put(c, 1);
			} else {
				dict.put(c, dict.get(c) + 1);
			}
		}
		HashMap<Character, Integer> found = new HashMap<Character, Integer>();
		int counter = 0;
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		String minWindow = "";
		while (end < source.length()) {
			char c = source.charAt(end);
			// for each new char in source
			if (dict.containsKey(c)) {
				if (found.containsKey(c)) {
					if (found.get(c) < dict.get(c)) {
						counter++;
					}
					found.put(c, found.get(c) + 1);
				} else {
					found.put(c, 1);
					counter++;
				}
			}
			// when counter equals to target.length(), found all characters
			if (counter == target.length()) {
				char sc = source.charAt(start);
				while (!found.containsKey(sc) || found.get(sc) > dict.get(sc)) {
					if (found.containsKey(sc) && found.get(sc) > dict.get(sc)) {
						found.put(sc, found.get(sc) - 1);
					}
					start++;
					sc = source.charAt(start);
				}
				if (end - start + 1 < minLen) {
					minWindow = source.substring(start, end + 1);
					minLen = end - start + 1;
				}
			}
			end++;
		}
		return minWindow;
	}

	// target may contains duplicate char
	public static String minWindows(String source, String target) {
		if (source == null || source.length() == 0) {
			return "";
		}
		if (source.length() == 1) {

		}
		int p = 0;
		int minLen = Integer.MAX_VALUE;
		int head = Integer.MAX_VALUE;
		int tail = Integer.MIN_VALUE;
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		while (p < source.length()) {
			if (target.contains(source.substring(p, p + 1))
					&& !hm.containsKey(source.charAt(p))) {
				hm.put(source.charAt(p), p);

				head = Math.min(head, p);
				tail = Math.max(tail, p);
				if (hm.size() == target.length()) {
					minLen = Math.min(minLen, tail - head + 1);
				}
				p++;
			} else if (target.contains(source.substring(p, p + 1))
					&& hm.containsKey(source.charAt(p))) {
				int preIdx = hm.get(source.charAt(p));
				// TODO
			} else {
				p++;
			}
		}
		return source.substring(head, tail + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
