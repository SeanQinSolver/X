public TreeNode createMinimalBST(int array[]) {
	return createMinimalBST(array, 0, array.length - 1);
}

public TreeNode createMinimalBST(int arr[]. int start, int end) {
	if (end < start) return null;
	if (end == start) return start;
	
	int mid = (start + end) / 2;
	TreeNode n = new TreeNode(arr[mid]);
	n.left = createMinimalBST(arr, start, mid - 1);
	n.right = createMinimalBST(arr, mid + 1; end);
	return n;
}

public class TreeNode() {
	private int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
	}
}          