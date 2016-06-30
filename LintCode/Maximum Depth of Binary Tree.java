//non-recursion

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}

//NON-RECURSION VERSION2


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        int depth = 0;
        
        while (list.size() != 0) {
            ArrayList<TreeNode> newList = new ArrayList<TreeNode>();
            for (TreeNode node : list) {
                if (node.left != null) newList.add(node.left);
                if (node.right != null) newList.add(node.right);
            }
            list = new ArrayList<TreeNode>(newList);
            depth++;
        }
        return depth;
    }
}

//RECURSION

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
