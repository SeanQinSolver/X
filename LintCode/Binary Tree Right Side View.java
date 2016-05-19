/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        if (root == null) return rst;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        queue.offer(null);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.offer(null);
                }
            } else {
                if (queue.peek() == null) {
                    rst.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rst;
    }
}


//method2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int depth = 1;
        dfs(map, root, depth);
        
        List<Integer> rst = new ArrayList<Integer>();
        //注意map从头加入，所以获取的都是第一个,也就是right的值
        while (map.containsKey(depth)) {
            rst.add(map.get(depth));
            depth++;
        }
        return rst;
    }
    
    private void dfs(HashMap<Integer, Integer> map, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        map.put(depth, node.val);
        dfs(map, node.left, depth + 1);
        dfs(map, node.right, depth + 1);
    }
}