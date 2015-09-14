package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class TopologicalSorting {
	public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		for (int i = 0; i < graph.size(); i++) {
			assist(graph.get(i), res);
		}
		return res;
    }

	private static void assist(DirectedGraphNode cur,
			ArrayList<DirectedGraphNode> res) {
		if (res.contains(cur)) {
			return;
		}
		ArrayList<DirectedGraphNode> nei = cur.neighbors;
		if (nei == null) {
			res.add(0, cur);
			return;
		}
		for (int i = 0; i < nei.size(); i++) {
			assist(nei.get(i), res);
		}
		res.add(0, cur);
		return;
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
		
		ArrayList<DirectedGraphNode> res= topSort(graph);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i).label + " - ");
		}
	}

}
