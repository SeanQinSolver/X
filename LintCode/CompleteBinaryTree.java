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


//method2 追踪number of nodes.如果某个的index 大于等于nodes.那么定不是complete binary tree


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        if (root == null) return true;
        int number = countNodes(root);
        return isComplete(root, 0, number);
    }
    
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private boolean isComplete(TreeNode node, int index, int number_nodes) {
        if (node == null) {
            return true;
        }
        if (index >= number_nodes) {
            return false;
        }
        return (isComplete(node.left, 2 * index + 1, number_nodes) && isComplete(node.right, 2 * index + 2, number_nodes));
    }
}
