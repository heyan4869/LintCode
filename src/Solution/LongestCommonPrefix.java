package Solution;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() < minLen) {
				minLen = strs[i].length();
			}
		}

		int index = 0;
		while (index < minLen) {
			char curr = strs[0].charAt(index);
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].charAt(index) == curr) {
					continue;
				} else {
					if (index == 0) {
						return "";
					} else {
						return strs[0].substring(0, index);
					}
				}
			}
			index++;
		}
		return strs[0].substring(0, index);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
