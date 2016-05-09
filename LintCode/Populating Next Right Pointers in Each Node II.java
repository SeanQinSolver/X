/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode parent = root;
        TreeLinkNode nextStart;
        
        while (parent != null) {
            
            TreeLinkNode start = null;
            nextStart = null;
            
            while (parent != null) {
                //可能出现第三层左枝完全没有的情况，那么nextStart在左边的时候一直为null，要随时更新nextStart（此时应起始于右边）
                if (nextStart == null) {
                    nextStart = parent.left != null ? parent.left : parent.right;
                }
                
                if (parent.left != null) {
                    if (start == null) {
                        start = parent.left;
                    } else {
                        start.next = parent.left;
                        start = start.next;
                    }
                }
                
                if (parent.right != null) {
                    if (start == null) {
                        start = parent.right;
                    } else {
                        start.next = parent.right;
                        start = start.next;
                    }
                }
                parent = parent.next;
            }
            parent = nextStart;
        }
    }
}