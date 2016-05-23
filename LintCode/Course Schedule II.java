//queue bfs

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> list = new ArrayList<Set<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            list.add(new HashSet<Integer>());
        }
        
        
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] countVertex = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int x : list.get(i)) {
                countVertex[x]++;
            }
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (countVertex[i] == 0) {
                queue.offer(i);
            }
        }
        
        
        int[] rst = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            for (Integer x : list.get(temp)) {
                countVertex[x]--;
                if (countVertex[x] == 0) {
                    queue.offer(x);
                }
            }
            rst[count++] = temp;
        }
        
        if (count == numCourses) return rst;
        return new int[0];
    }
}

// 写法2，比较浪费的写法List<List<Integer>>


public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        int[] countVertex = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            countVertex[prerequisites[i][0]]++;
        }
        
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (countVertex[i] == 0) {
                queue.offer(i);
            }
        }
        
        //写法1 dfs------------
        int[] rst = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            for (Integer x : list.get(temp)) {
                countVertex[x]--;
                if (countVertex[x] == 0) {
                    queue.offer(x);
                }
            }
            rst[count++] = temp;
        }
        //--------------------
        
        //写法2. bfs + dfs-----
        while (!queue.isEmpty()) {
            int sizeTemp = queue.size();
            for (int i = 0; i < sizeTemp; i++) {
                int temp = queue.poll();
                for (int x : list.get(temp)) {
                    countVertex[x]--;
                    if (countVertex[x] == 0) queue.offer(x);
                }
                rst[count++] = temp;
            }
        }
        //--------------------
        
        if (count == numCourses) return rst;
        return new int[0];
    }
}

//method 3 dfs
