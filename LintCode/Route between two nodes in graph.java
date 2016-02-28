/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
 

public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        
        Set<DirectedGraphNode> set = new HashSet<DirectedGraphNode>();
        return helper(graph, s, t, set);
    }
    private boolean helper(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t, Set<DirectedGraphNode> set) {
        if (s == t) {
            return true;
        } else {
            set.add(s);
            for (DirectedGraphNode g : s.neighbors) {
                if (set.contains(g)) continue;
                else if (helper(graph, g, t, set)) return true;
            }
        }
        return false;
    }
}