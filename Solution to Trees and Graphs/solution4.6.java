public class Solution() {
	public TreeNode inorder'Succ(TreeNode n) {
		if (n == null) return null;

		if (n.right != null) {
			TreeNode m = n.right;
			while (m.left != null) {
				m = m.left;
			} 
			return m;
		} else {
			TreeNode m = n.parent;
			while (m != null && m.left != n) {
				n = m;
				m = m.parent;
			}
			return m;
		}
	}
}