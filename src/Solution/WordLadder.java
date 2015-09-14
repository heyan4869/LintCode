// hard

package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		if (dict.isEmpty()) {
			return -1;
		}
		dict.add(start);
		dict.add(end);
		// no need to build the whole graph 
		// Map<String, ArrayList<String>> graph = new HashMap<String,
		// ArrayList<String>>();
		// assist(graph, dict);
		Queue<String> q1 = new LinkedList<String>();
		Queue<String> q2 = new LinkedList<String>();
		int step = 1;

		q1.add(start);
		Boolean flag = true;
		Set<String> visited = new HashSet<String>();
		visited.add(start);
		while (flag) {
			step++;
			while (!q1.isEmpty()) {
				ArrayList<String> nei = assist(q1.poll(), dict);
				
				for (int i = 0; i < nei.size(); i++) {
					if (nei.get(i).equals(end)) {
						flag = false;
						break;
					} else {
						if (!visited.contains(nei.get(i))) {
							visited.add(nei.get(i));
							q2.add(nei.get(i));
						}
					}
				}
			}
			Queue<String> temp = new LinkedList<String>();
			temp = q1;
			q1 = q2;
			q2 = temp;
		}

		return step;
	}

	// get the neighbors
	private static ArrayList<String> assist(String str, Set<String> dict) {
		ArrayList<String> edge = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int idx = 97; idx <= 122; idx++) {
				String temp = str.substring(0, i) + (char) idx
						+ str.substring(i + 1, str.length());
				if (temp.equals(str)){
					continue;
				} else if (dict.contains(temp)) {
					edge.add(temp);
				}
			}
		}
		return edge;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start = "hit";
		String end = "hot";
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		System.out.println(ladderLength(start, end, dict));
	}

}
