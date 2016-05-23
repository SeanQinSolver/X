//method1 用List<List<Integer>> list去存映射
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> rst = new ArrayList<Integer>();
        
        if (edges == null || edges.length == 0) {
            rst.add(0);
            return rst;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        //n代表有多少个点
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        int[] array = new int[n];
        //每两个点对应的出度和每一个点的入肚对应起来
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            array[edges[i][1]]++;
            list.get(edges[i][1]).add(edges[i][0]);
            array[edges[i][0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            //入度为1的点先存到QUEUE里面，就是LEAF
            if (array[i] == 1) {
                queue.offer(i);
            }
        }
        
        //循环到值剩两个点
        int count = n;
        while (n > 2) {
            int sizeTemp = queue.size();
            for (int i = 0; i < sizeTemp; i++) {
                int temp = queue.poll();
                n--;
                for (int x : list.get(temp)) {
                    array[x]--;
                    if (array[x] == 1) queue.offer(x);
                }
            }
        }
        
        while (!queue.isEmpty()) rst.add(queue.poll());
        return rst;
    }
}

//metho2 用HASHMAP存映射


public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        List<Integer> rst = new ArrayList<Integer>();
        
        if (edges == null || edges.length == 0) {
            rst.add(0);
            return rst;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        
        int[] array = new int[n];
        
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            array[edge[1]]++;
            map.get(edge[1]).add(edge[0]);
            array[edge[0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                queue.offer(i);
            }
        }
        
        int count = n;
        while (count > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int x : map.get(temp)) {
                    array[x]--;
                    if (array[x] == 1) queue.offer(x);
                }
                count--;
            }
        }
        
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }
        return rst;
    }
}