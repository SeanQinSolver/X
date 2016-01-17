/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        list.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        int start = 0;
        while (start < list.size()) {
            UndirectedGraphNode head = list.get(start++);
            //start++;
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (map.containsKey(neighbor)) {
                    continue;
                }
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                list.add(neighbor);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            UndirectedGraphNode newNode = map.get(list.get(i));
            for (int j = 0; j < list.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(list.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}