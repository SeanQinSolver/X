public class RangeSumOfBST {

	public int rangeSumBST(TreeNode root, int i, int j) {

		if (root == null) return 0;
		if (root.val < i) return rangeSumBST(root.right, i, j);
		if (root.val > j) return rangeSumBST(root.left, i, j)
 
		return root.val + rangeSumBST(root.left, i, j) + rangeSumBST(root.right, i, j);

	}


	private static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int val) {
			this.val = val;
		}
	}
}