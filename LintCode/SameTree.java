public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p.value != q.value) return false;
		if (p == null && q == null) return true;
		boolean left = isSameTree(p.left, q.left);
		boolean right = isSameTree(p.right, q.right);

		return left && right;

	}

	private static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;
		public TreeNode(value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}