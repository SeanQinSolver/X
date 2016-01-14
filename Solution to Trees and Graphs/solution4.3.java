//method1 pre-order travers
public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> list, int level) {
   if (root == null) return;

   LinkedList<TreeNode> list = null;
   if (lists.size() == level) {
   		list = new LinkedList<TreeNode>();
   		lists.add(list);
   } else {
   		list = lists.get(level);
   }
   list.add(root);
   createLevelLinkedList(root.left, lists, level + 1);
   createLevelLinkedList(root.right, lists, level + 1);
}

public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
	createLevelLinkedList(root, lists, 0);
	return lists;
}

//method2 breadth-first search

public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
	if (root == null) return null;
	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	
	current.add(root);

	while (current.size() > 0) {
		result.add(current);
		LinkedList<TreeNode> parents = current;
		current = new LinkedList<TreeNode>();
		for (TreeNode parent : parents) {
			if (parent.left != null) {
				current.add(parent.left);
			}
			if (parent.right != null) {
				current.add(parent.right);
			}
		}
	}
	return result;
}