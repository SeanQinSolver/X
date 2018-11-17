import java.util.*;

public class Zookeeper{

	TrieNode root;

	public static void main(String[] args) {
		Zookeeper zk = new Zookeeper();

		zk.create("a", 1);
        int val = zk.getValue("a");
        System.out.println("a: " + val);
        zk.setValue("a", 2);
        System.out.println("a: " + zk.getValue("a"));
        zk.create("a/c/d", 3);
        zk.create("a/b", 2);
        System.out.println("a/b: " + zk.getValue("a/b"));
        zk.create("a/b", 3);
        zk.setValue("d/c", 4);
        zk.getValue("d/c");
	}

	public Zookeeper() {
		root = new TrieNode("r", -1);
	}

	// Check if it already exists by going through from root find the parentNode
	// If parentNode.children has the last Name, it is already in the set.
	public void create(String path, Integer value) {
		String[] paths = path.split("/");
		String lastName = paths[paths.length - 1];
		// Update the path by removing the last one
		paths = Arrays.copyOfRange(paths, 0, paths.length - 1);
		TrieNode parentNode = findPathFromRoot(paths);
		if (parentNode.children.containsKey(lastName)) {
			System.out.println("Path already exists");
		} else {
			TrieNode node = new TrieNode(lastName, value);
			parentNode.children.put(lastName, node);
		}
	}

	private TrieNode findPathFromRoot(String[] paths) {
		TrieNode move = this.root;
		for (String name : paths) {
			if (move.children.containsKey(name)) {
				move = move.children.get(name);
			} else {
				System.out.println("Path does not exists");
				return this.root;
			}
		}
		return move;
	}

	private void setValue(String path, Integer value) {
		String[] paths = path.split("/");
		TrieNode node = findPathFromRoot(paths);
		if (node != this.root) {
			node.value = value;
		}
	}

	private int getValue(String path) {
		String[] paths = path.split("/");
		TrieNode node = findPathFromRoot(paths);
		if (node != this.root) return node.value;
		return -1;
	}

	private static class TrieNode {
		String name;
		Integer value;
		Map<String, TrieNode> children;

		public TrieNode(String name, Integer value) {
			this.name = name;
			this.value = value;
			children = new HashMap<>();
		}
	}
}