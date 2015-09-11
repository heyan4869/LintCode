package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class RouteBetweenTwoNodesInGraph {
	public static boolean hasRoute(ArrayList<DirectedGraphNode> graph,
			DirectedGraphNode s, DirectedGraphNode t) {
		// in case of loop exists
		ArrayList<DirectedGraphNode> visited = new ArrayList<DirectedGraphNode>();
		return assist(visited, graph, s, t);
	}

	private static boolean assist(ArrayList<DirectedGraphNode> visited,
			ArrayList<DirectedGraphNode> graph, DirectedGraphNode cur, DirectedGraphNode target) {
		if (!graph.contains(cur) || visited.contains(cur)) {
			return false;
		}
		if (cur == target) {
			return true;
		}
		visited.add(cur);
		ArrayList<DirectedGraphNode> nei = cur.neighbors;
		Boolean res = false;
		for (int i = 0; i < nei.size() && !res; i++) {
			res = res || assist(visited, graph, nei.get(i), target);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedGraphNode A = new DirectedGraphNode(1);
		DirectedGraphNode B = new DirectedGraphNode(2);
		DirectedGraphNode C = new DirectedGraphNode(3);
		DirectedGraphNode D = new DirectedGraphNode(4);
		DirectedGraphNode E = new DirectedGraphNode(5);
		
		A.neighbors = new ArrayList<>(Arrays.asList(B, D));
		B.neighbors = new ArrayList<>(Arrays.asList(C, D));
		C.neighbors = new ArrayList<>();
		D.neighbors = new ArrayList<>(Arrays.asList(E));
		E.neighbors = new ArrayList<>();
		
		ArrayList<DirectedGraphNode> graph = new ArrayList<>(Arrays.asList(A, B, C, D, E));
		System.out.println(hasRoute(graph, B, E));
	}

}
