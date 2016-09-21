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


//method2

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
        
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        
        ArrayList<ParentTreeNode> listA = new ArrayList<>();
        ArrayList<ParentTreeNode> listB = new ArrayList<>();
        
        while (A != root) {
            listA.add(0, A);
            A = A.parent;
        }
        listA.add(0, A);
        while (B != root) {
            listB.add(0, B);
            B = B.parent;
        }
        listB.add(0, B);
        
        int index = 0;
        while (index < listA.size() && index < listB.size()) {
            if (listA.get(index) != listB.get(index)) {
                return listA.get(index).parent;
            }
            index++;
        }
        int size = listA.size() > listB.size() ? listB.size() : listA.size();
        return listA.get(size - 1);
        
        
        // int size = listA.size() > listB.size() ? listB.size() : listA.size();
        
        // for (int i = 0; i < size; i++) {
        //     if (listA.get(i) != listB.get(i)) {
        //         return listA.get(i).parent;
        //     }
        // }
        
        // return listA.get(size - 1);
    }
}

//method3

public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
        
        Set<TreeNode> visited = new HashSet<>();
        
        while (A != root) {
            visited.add(A);
            A = A.parent;
        }
        visited.add(A);
        
        if (visited.contains(B)) {
            return B;
        }
        
        while (B != root) {
            if (visited.contains(B)) {
                return B;
            }
            B = B.parent;
        }
        
        if (visited.contains(B)) {
            return B;
        }
        return null;
