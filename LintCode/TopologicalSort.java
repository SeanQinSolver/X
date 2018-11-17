// Topological sort is only for DAG.
// DFS

import java.util.*;

public class TopologicalSort {
	public static void main(String[] args) {
		Node seven = new Node("7");
		Node five = new Node("5");
		Node three = new Node("3");
		Node eleven = new Node("11");
		Node eight = new Node("8");
		Node two = new Node("2");
		Node nine = new Node("9");
		Node ten = new Node("10");
		seven.addEdge(eleven).addEdge(eight);
    	five.addEdge(eleven).addEdge(ten);
    	three.addEdge(eight).addEdge(ten);
    	eleven.addEdge(two).addEdge(nine).addEdge(ten);
    	eight.addEdge(nine).addEdge(ten);
    	Node[] nodes = {seven, five, three, eleven, eight, two, nine, ten};
    	TopologicalSort tps = new TopologicalSort();
    	ArrayList<Node> list = tps.ts(nodes);
    	for (Node n : list) {
    		System.out.println(n.name);
    	}
	}
	
	static class Node {
		String name;
		HashSet<Edge> inEdges;
		HashSet<Edge> outEdges;

		public Node(String name) {
			this.name = name;
			inEdges = new HashSet();
			outEdges = new HashSet();
		}

		public Node addEdge(Node node) {
			Edge e = new Edge(this, node);
			outEdges.add(e);
			node.inEdges.add(e);
			return this;
		}
		@Override
		public String toString() {
			return name;
		}
	}

	static class Edge {
		Node to;
		Node from;
		public Edge(Node from, Node to) {
			this.to = to;
			this.from = from;
		}
	}

	private ArrayList<Node> ts(Node[] nodes) {
		if (nodes == null || nodes.length == 0) return new ArrayList<>();

		ArrayList<Node> res = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		for (Node n : nodes) {
			if (n.inEdges.size() == 0) {
				queue.add(n);
			}
		}

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			res.add(n);
			for (Edge e : n.outEdges) {
				Node m = e.to;
				m.inEdges.remove(e);
				if (m.inEdges.isEmpty()) {
					queue.offer(m);
				} 
			}
		}
		return res;
	}
}