public boolean isBalanced(TreeNode node) {
return helper(node) != -1;
}
private int helper(TreeNode node) {
if (node == null) {
return 0;
}

int left = helper(node.left);
int right = helper(node.right);

//System.out.println(left + "  " + right);

if (Math.abs(left - right) > 1 || left == -1 || right == -1) return -1;

return Math.max(left, right) + 1;
}


//写法2

public boolean isBalanced(TreeNode node) {
return check(node) == -1 ? false : true;
}
private int check(TreeNode node) {
if (node == null) return 0;
int left = check(node.left);
int right = check(node.right);
if (Math.abs(left - right) > 1) return -1;
if (left == -1 || right == -1) return -1;

return Math.max(left, right) + 1;
}