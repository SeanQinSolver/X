public class LevelTraversal {

	public static void main(String[] args) {
		
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {
			int len = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) { 
					queue.offer(node.right);
				}
			}
			result.add(list);
		}
		return result;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
		}
	}
}


// Queue 的思路去做