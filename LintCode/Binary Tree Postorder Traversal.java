//method1 iteration
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
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            //没有CHILD
            boolean nochild = (curr.left == null) && (curr.right == null);
            boolean childVisited = false;
            if (prev != null && (curr.left == prev || curr.right == prev)) {
                childVisited = true;
            }
            if (nochild || childVisited) {
                result.add(curr.val);
                stack.pop();
                prev = curr;
            } else {
                if (curr.right != null)  stack.push(curr.right);
                if (curr.left != null) stack.push(curr.left);
            }
        }
        return result;
    }
}

//method2 recursion
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<INteger>();
        if (root == null) {
            List<Integer> left = postorderTraversal(root.left);
            result.addAll(left);
            List<integer> right = postorderTraversal(root.right);
            result.addAll(right);
            result.add(root.val);
        }
        return result;
    }
}