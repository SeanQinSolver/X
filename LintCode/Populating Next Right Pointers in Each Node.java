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
        if (root == null) return;
        
        TreeLinkNode parent = root;
        TreeLinkNode nextStart = root.left;
        
        while (parent != null && nextStart != null) {
            TreeLinkNode start = null;
            while (parent != null) {
                if (start == null) {
                    start = parent.left;
                }else {
                    start.next = parent.left;
                    start = start.next;
                }
                start.next = parent.right;
                start = start.next;
                parent = parent.next;
            }
            parent = nextStart;
            nextStart = parent.left;
        }
    }
}

//两层while循环：第一层是跳动每一层，第二层是每一层的循环