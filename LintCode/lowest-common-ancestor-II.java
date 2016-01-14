public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    
        
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
       int depthA = getDepth(A);
       int depthB = getDepth(B);
       int depthDiff = depthA - depthB;
       //the deeper node
       ParentTreeNode deepNode = depthDiff > 0 ? A : B;
       //the shallow node
       ParentTreeNode shallowNode = depthDiff > 0 ? B : A;
       
       deepNode = goUpTo(deepNode, Math.abs(depthDiff));
       
       while (deepNode != shallowNode && deepNode != null && shallowNode != null) {
           deepNode = deepNode.parent;
           shallowNode = shallowNode.parent;
       }
       return shallowNode;
    }
    
    public int getDepth(ParentTreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }
    
    public ParentTreeNode goUpTo(ParentTreeNode node, int depthDiff) {
        while (depthDiff > 0) {
            node = node.parent;
            depthDiff--;
        }
        return node;
    }
}
