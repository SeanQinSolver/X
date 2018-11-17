
public class SplitBst {


	public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null) {
			return new TreeNode[]{null, null};
		} else if (root.val < V) {
			TreeNode[] temp = splitBST(root.right, V);
			root.right = temp[0];
			temp[0] = root;
			return temp;
		} else {
			TreeNode[] temp = splitBST(root.left, V);
			root.left = temp[1];
			temp[1] = root;
			return temp;
		}
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);

		n4.left = n2;
		n4.right = n6;
		n2.left = n1;
		n2.right = n3;
		n6.left = n5;
		n6.right = n7;

		SplitBst sb = new SplitBst();
		TreeNode[] arr = sb.splitBST(n4, 3);
		//System.out.println(arr[0].val); // small 
		System.out.println(arr[1].val); // large
		System.out.println(arr[1].left.val);
 
	}

	private static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
		public TreeNode(int val) {
			this.val = val;
		}
	}
}