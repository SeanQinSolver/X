//method1-BFS
public enum State {Unvisited, Visited, Visiting;}

public boolean search(Graph g, Node start, Node end) {
	if (start == end) return true;
	if (start == null || end == null) return false;

	LinkedList<Node> q = new LinkedList<Node>();

	for (Node u : g.getNodes()) {
		u.state = State.Unvisited;
	}
	start.state = State.Visiting;
	q.add(start);

	while(!q.isEmpty()) {
		Node u = q.removeFirst();
		if (u != null) {
			for (Node v : u.getAjacent()) {
				if (v.state == State.Unvisited) {
					if (v == end) {
						return true;
					} else {
						v.state = State.Visiting;
						q.add(v);
					}
				}
			}
			u.state = State.Visited;
		}	
	}
	return false;
}	

//method2-BFS
public boolean search(Graph g, Node start, Node end) {
	boolean[] marker = new boolean[];
	if (start == null || end == null) return false;
	if (start == end) return true;

	LinkedList<Node> queue = new LinkedList<Node>();

	for (Node u : g.getNodes()) {
		marker[u] = false;
	}

	queue.add(start);

	while(!queue.isEmpty()) {
		Node u = queue.removeFirst();
		if(u != null) {
			for (Node m : v.getAjacent()) {
				if (marker[m] == false) {
					if (m == end) return true;
					else queue.add(m);
				}
			}
		}
		marker[u] = true;
	}
}
//method3 DFS

public boolean search(Graph g, Node start, Node end) {
	if (start == null || end == null) return false;
	if (start == end) return true;
	boolean[] marker = new boolean[];
	marker[start] = true;
	
 	for (Node u : start.getAjacent()) {
 		if (marker[u] == false) {
 			if (u == end) return true;
			else return search(Graph g, Node u, Node end);
 		}
	}
}
