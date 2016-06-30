/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    private static class TreeNode {
        //val为priority
        public int val;
        public String s;
        public ExpressionTreeNode root;
        
        public TreeNode(int val, String ss) {
            this.val = val;
            this.root = new ExpressionTreeNode(ss);
        }
    }
    private int getPriority(String a, Integer base) {
        if (a.equals("+") || a.equals("-")) {
            return 1 + base;
        }
        if (a.equals("*") || a.equals("/")) {
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    }
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = null;
        int val = 0;
        Integer base = 0;
        //注意index到expression.length
        for (int i = 0; i <= expression.length; i++) {
            if (i != expression.length) {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                }
                if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                }
                val = getPriority(expression[i], base);
            }
            TreeNode right = null;
            if (i == expression.length) {
                right = new TreeNode(Integer.MIN_VALUE, "X");
            } else {
                right = new TreeNode(val, expression[i]);
            }
            
            while (!stack.isEmpty()) {
                if (right.val <= stack.peek().val) {
                    TreeNode nodeNow = stack.pop();
                    if (stack.isEmpty()) {
                        right.root.left = nodeNow.root;
                    } else {
                        TreeNode left = stack.peek();
                        //比较priority
                        if (left.val < right.val) {
                            right.root.left = nodeNow.root;
                        } else {
                            left.root.right = nodeNow.root;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
    }
}