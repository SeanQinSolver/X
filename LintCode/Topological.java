/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        //把所有的入度给用map装起来
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        //查找那个入度为零的
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }
        //bfs + dfs，先bfs临近的点，再dfs没一层。将入度为零的加入queue中
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    queue.offer(n);
                }
            }
        }
        return result;
    }
}