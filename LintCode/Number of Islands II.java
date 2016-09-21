//method1
//https://leetcode.com/discuss/69392/python-clear-solution-unionfind2d-weighting-compression?show=69392#q69392


public class Solution {
    
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> rst = new ArrayList<Integer>();
        
        boolean[][] isIsland = new boolean[m][n];
        
        int[] fa = new int[m * n];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        
        int count = 0;
        
        for (int[] position : positions) {
            count++;
            isIsland[position[0]][position[1]] = true;
            int oldPos = position[0] * n + position[1];
            
            for (int i = 0; i < directions.length; i++) {
                int newX = position[0] + directions[i][0];
                int newY = position[1] + directions[i][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && isIsland[newX][newY] == true && fa[getfather(fa, newX * n + newY)] != oldPos) {
                    
                    fa[getfather(fa, newX * n + newY)] = oldPos;
                    count--;
                }
            }
            rst.add(count);
        }
        return rst;
    }
    
    public int getfather(int[] fa, int i) {
        if (fa[i] == i) return i;
        fa[i] = getfather(fa, fa[i]);
        return fa[i];
    }
    
    
    //get father 写法2
    
    private int getFather(int[] father, int i) {
        while (i != father[i]) {
            i = father[i];
        }
        return i;
    }
}

//method2
//However, if the map is very big, then the initialization of the arrays can cost a lot of time when mn is much larger than N. In this case we should consider using a hashmap/dictionary for the underlying data structure to avoid this overhead.

public class Solution {
    
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> rst = new ArrayList<Integer>();
        
        boolean[][] isIsland = new boolean[m][n];
        UnionFind uf = new UnionFind(m * n);
        
        int count = 0;
        for (int[] position : positions) {
            count++;
            int oldPos = position[0] * n + position[1];
            isIsland[position[0]][position[1]] = true;
            for (int i = 0; i < directions.length; i++) {
                int newX = position[0] + directions[i][0];
                int newY = position[1] + directions[i][1];
                int newPos = newX * n + newY;
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && isIsland[newX][newY] && uf.find(oldPos) != uf.find(newPos)) {
                    count--;
                    //此处让
                    uf.union(oldPos, newPos);
                }
            }
            rst.add(count);
        }
        return rst;
    }
    
    class UnionFind {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        public UnionFind(int len) {
            for (int i = 0; i < len; i++) {
                map.put(i, i);
            }
        }
        
        public int find(int x) {
            int parent = map.get(x);
            while (parent != map.get(parent)) {
                parent = map.get(parent);
            }
            
            return parent;
        }
        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX != parentY) {
                map.put(parentX, parentY);
            }
        }
    }
}