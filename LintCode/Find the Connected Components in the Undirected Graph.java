/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        Map<UndirectedGraphNode, Boolean> map = new HashMap<UndirectedGraphNode, Boolean>();
        for (UndirectedGraphNode node : nodes) {
            map.put(node, false);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (UndirectedGraphNode node : nodes) {
            if (map.get(node) == false) {
                bfs(node, map, result);
            }
        }
        return result;
    }
    
    private void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> map, List<List<Integer>> result) {
        
        List<Integer> path = new ArrayList<Integer>();
        map.put(node, true);
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode nodeTmp = queue.poll();
            path.add(nodeTmp.label);
            for (UndirectedGraphNode nodeX : nodeTmp.neighbors) {
                if (map.get(nodeX) == false) {
                    map.put(nodeX, true);
                    queue.offer(nodeX);
                }
            }
            
        }
        Collections.sort(path);
        result.add(path);
    }
}