//method1 runntime o(d), d is the deeper node

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

//method2 store in a arrayList, use o(d) space, o(t) time
//t is length until the first difference node

public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    
        
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        List<ParentTreeNode> listA = putIntoArrayList(A);
        List<ParentTreeNode> listB = putIntoArrayList(B);
        int i = 0, j = 0;
        for (i = listA.size() - 1, j = listB.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (listA.get(i) != listB.get(j)) {
                return listB.get(j).parent;
            }
        }
        return listB.get(j + 1);
    }
    
    public ArrayList<ParentTreeNode> putIntoArrayList(ParentTreeNode node) {
        ArrayList<ParentTreeNode> list = new ArrayList<ParentTreeNode>();
        while (node != null) {
            list.add(node);
            node = node.parent;
        }
        return list;
    }
}
