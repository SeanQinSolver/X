//Method1 

public int getHeight(TreeNode root) {
	if (root == null) return -1;
	return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}

public boolean isBalanced(TreeNode root) {
	if (root == null) return true;

	int heightDiff = getHeight(root.left) - getHeight(root.right);\
	if (Math.abs(heightDiff) > 1) {
		return false;
	} else {
		return isBalanced(root.left) && isBalanced(root.right);
	}
}

//Method2

public int checkHeight(TreeNode root) {
	if (root == null) return -1;

	int leftHeight = checkHeight(root.left);
	if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

	int rightHeight = checkHeight(root.right);
	if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

	if (Math.abs(leftHeight - rightHeight) > 1) {
		return Integer.MIN_VALUE;
	} else {
		return Math.max(leftHeight, rightHeight) + 1;
	}
}

public boolean isBalanced(TreeNode root) {
	return checkHeight(root) != Integer.MIN_VALUE;
}