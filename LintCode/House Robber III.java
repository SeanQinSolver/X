/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

//Method1
//now[0]表示以i为根子树不偷根节点而获得的最高值。
//now[1]表示以i为根子树偷根节点的最高值
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            int[] now = new int[]{0, 0};
            return now;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] now = new int[2];
        //注意此点用{1, 2, 3, 5,4}去测试
        now[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        now[1] = left[0] + right[0] + root.val;
        return now;
    }
}


//Method2

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    
    class ResultType {
        public int rob, not_rob;
        public ResultType() {
            rob = not_rob = 0;
        }
    }
    public int houseRobber3(TreeNode root) {
        ResultType result = visit(root);
        return Math.max(result.rob, result.not_rob);
    }
    
    private ResultType visit(TreeNode root) {
        ResultType result = new ResultType();
        if (root == null) return result;
        
        ResultType left = visit(root.left);
        ResultType right = visit(root.right);
        
        result.rob = root.val + left.not_rob + right.not_rob;
        result.not_rob = Math.max(left.not_rob, left.rob) + Math.max(right.not_rob, right.rob);
        return result;
    }
}
