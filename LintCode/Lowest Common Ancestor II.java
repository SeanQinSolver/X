/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    
    
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        if (!isCovered(root, A) || !isCovered(root, B)) {
            return null;
        } else if (isCovered(A, B)) {
            return A;
        } else if (isCovered(B, A)) {
            return B;
        }
        
        ParentTreeNode sibling = getSibling(A);
        ParentTreeNode parent = A.parent;
        while (!isCovered(sibling, B)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }
    
    public boolean isCovered(ParentTreeNode node1, ParentTreeNode node2) {
        if (node1 == null) return false;
        if (node1 == node2) return true;
        
        return isCovered(node1.left, node2) || isCovered(node1.right, node2);
    }
    
    public ParentTreeNode getSibling(ParentTreeNode node) {
        if (node == null || node.parent == null) {
            return null;
        }
        ParentTreeNode parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }
}

