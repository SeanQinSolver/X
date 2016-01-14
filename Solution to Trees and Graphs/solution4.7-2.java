public class Solution {

	public Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes);
	}

	public Stack<Project> orderProjects(ArrayList<Project> projects) {
		Stack<Project> stack = new Stack<Project>();
		for (Project project : projects) {
			if (project.getState() == Project.State.BLANK) {
				IF (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}

	public boolean doDFS(Project project, Stack<Project> stack) {
		if (project.getState() == Project.State.PARTIAL) {
			return false; //cycle        
		}

		if (project.getState == Project.State.BLANK) {
			project.setState(Project.State.PARTIAL);
			ArrayList<Project> children = project.getChildren();
			//最后一个Node的child为null,直接跳过这里
			for (Project child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			+9
			project.setState(Project.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}




	public Graph buildGraph(String[] projects. String[][] dependencies) {
		Graph graph = new Graph();
		for(String project : projects) {
			graph.getOrCreateNode(project.getName());
		}

		for (String[] dependencies : dependencies) {
			String first = dependencies[0];
			String second = dependencies[1];
			graph.addEdge(first, second);
		}
		return graph;
	}
}



class Graph {
	private ArrayList<Project> nodes = new ArrayList<Project>();
	//map存放此graph所有project及对应的名字
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}

	public void addEdge(String startName, String endName) {
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}

	public ArrayList<Project> getNodes() {return nodes;}

}

class Project {
	public enum State {COMPLETE, PARTIAL, BLANK};
	private State state = State.BLANK;
	public State getState() {return state;}
	public void setState(State st) {state = st;}

	private ArrayList<Project> children = new ArrayList<Project>();
	//map存放此project的child及parent
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;

	public String getName() {return name;}
	public ArrayList<Project> getChildren() {return children;}
	

	public Project(String n) {
		this.name = n;
	}
	public void addNeighbor(String node) {
		if (!map.containsKey(node.getName())) {
			children.add(node);                                                                          
		}
	}
}