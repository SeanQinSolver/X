//只要出现左node为null,右node不为null就出局。或者第一个孩子出现的node的其右边的node的child不为null也出局

public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
   public boolean isComplete(TreeNode root) {
    	if (root == null) {
    	    return true;
    	}
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	boolean flag = false;
    	while (!queue.isEmpty()) {
    	    TreeNode node = queue.poll();
    	    if (flag && (node.left != null || node.right != null)) {
    	        return false;
    	    }
    	    if (node.left == null && node.right != null) {
    	        return false;
    	    }
    	    if (node.left == null || node.right == null) {
    	        flag = true;
    	    }
            
    	    if (node.left != null) queue.offer(node.left);
    	    if (node.right != null) queue.offer(node.right);
    	}
    	return true;
    }
}