package Solution;

import java.util.ArrayList;

public class LongestWords {
	public static ArrayList<String> longestWords(String[] dictionary) {
		ArrayList<String> res = new ArrayList<String>();
		if (dictionary == null || dictionary.length == 0) {
			return res;
		}
		int maxLen = 0;
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].length() > maxLen) {
				maxLen = dictionary[i].length();
				res.clear();
				res.add(dictionary[i]);
			} else if (dictionary[i].length() == maxLen) {
				res.add(dictionary[i]);
			} else {
				continue;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] d = { "like", "love", "hate", "yes" };
		ArrayList<String> res = longestWords(d);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
