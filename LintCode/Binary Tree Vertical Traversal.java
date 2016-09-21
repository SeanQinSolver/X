/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (root == null) return rst;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNodeNum> queue = new ArrayDeque<TreeNodeNum>();
        TreeNodeNum rootNum = new TreeNodeNum(root, 0);
        queue.offer(rootNum);
        int maxCol = 0;
        int minCol = 0;
        
        while (!queue.isEmpty()) {
            TreeNodeNum node = queue.poll();
            if (map.containsKey(node.col)) {
                map.get(node.col).add(node.treeNode.val);
            } else {
                map.put(node.col, new ArrayList<Integer>(Arrays.asList(node.treeNode.val)));
            }
            
            if (node.treeNode.left != null) {
                TreeNodeNum numLeft = new TreeNodeNum(node.treeNode.left, node.col - 1);
                queue.offer(numLeft);
                minCol = Math.min(minCol, node.col - 1);
            }
            if (node.treeNode.right != null) {
                TreeNodeNum numRight = new TreeNodeNum(node.treeNode.right, node.col + 1);
                queue.offer(numRight);
                maxCol = Math.max(maxCol, node.col + 1);
            }
        }
        
        for (int i = minCol; i <= maxCol; i++) {
            rst.add(map.get(i));
        }
        return rst;
    }
    
    private static class TreeNodeNum {
        int col;
        TreeNode treeNode;
        public TreeNodeNum(TreeNode treeNode, int col) {
            this.col = col;
            this.treeNode = treeNode;
        }
    }
}


//写法2

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        
        Queue<MapNode> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        //map.put(0, new ArrayList<>());
        //map.get(0).add(root.val);
        
        queue.offer(new MapNode(0, root));
        int min = 0;
        int max = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            //for (int i = 0;  i < size; i++) {
            MapNode mapNode = queue.poll();
            
            if (!map.containsKey(mapNode.level)) {
                map.put(mapNode.level, new ArrayList<>());
            }
            map.get(mapNode.level).add(mapNode.node.val);
            
            
            if (mapNode.node.left != null) {
                queue.offer(new MapNode(mapNode.level - 1, mapNode.node.left));
                min = Math.min(min, mapNode.level - 1);
                
            }
            if (mapNode.node.right != null) {
                queue.offer(new MapNode(mapNode.level + 1, mapNode.node.right));
                max = Math.max(max, mapNode.level + 1);
            }
            //}
        }
        
        for (int i = min; i <= max; i++) {
            //System.out.println(map.get(0));
            rst.add(map.get(i));
        }
        return rst;
    }
    
    class MapNode {
        int level;
        TreeNode node;
        public MapNode(int level, TreeNode node) {
            this.node = node;
            this.level = level;
        }
    }
}