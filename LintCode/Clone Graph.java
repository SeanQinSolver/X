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
    //{0, 1, 2 # 1, 2 # 2, 2}
    //# is separator of each node, , is separator of the node and its neighbors
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        ArrayList<UndirectedGraphNode> list = new ArrayList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        list.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        //bfs 存储所有的Node into map，对应的key, value是新建一个UndirecetedGraphNode
        int start = 0;
        while (start < list.size()) {
            UndirectedGraphNode head = list.get(start++);
            for (int i = 0; i < head.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                if (map.containsKey(neighbor)) {
                    continue;
                }
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                list.add(neighbor);
            }
        }
        //将map里面的各种node用neighbor链接起来
        for (int i = 0; i < list.size(); i++) {
            UndirectedGraphNode newNode = map.get(list.get(i));
            for (int j = 0; j < list.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(list.get(i).neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}
/*List 是用来储存所有现有的Node
 *此题注意，新建的Graph的各个node后要把neighbors加进去
 *解法先复制各个node，以map来判断是否已经复制了。再把各node的neighbor加上
 *
 */