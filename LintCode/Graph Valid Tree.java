public class Solution {
    private int[] father;
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        if (n - 1!= edges.length) {
            return false;
        }
        father = new int[n];
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (find(edges[i][0]) == find(edges[i][1])) {
                //System.out.println(edges[i][0] + " " + edges[i][1]);
                return false;
            }
            union(edges[i][0], edges[i][1]);
        }
        return true;
    }
    
    private int find(int node) {
        if (father[node] == node) {
            return node;
        }
        father[node] = find(father[node]);
        return father[node];
    }
    private void union(int node1, int node2) {
        father[find(node1)] = find(node2);
    }
}