//method1, BFS，但需要改进, 用HASHSET去存对应的边，详见method2
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        
        int[] countVertex = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            //用list去记录每一个出度对应的多个入度 [[1, 0]] 0->1
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            //用countVertex去记录每个点的入度
            countVertex[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        
        //查找入度为零的那个点，通常为起点
        for (int i = 0; i < numCourses; i++) {
            if (countVertex[i] == 0) {
                queue.offer(i);
            }
        }
        
        int count = numCourses;
        //注意这个是一条从头到尾的链接，无DAG (directed acyclic graph)
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            //遍历这个点为出度的所有的点
            for (int i : list.get(cur)) {
                countVertex[i]--;
                //若此点入度为零，则加入queue继续下一层
                if (countVertex[i] == 0) {
                    queue.offer(i);
                }
            }
            count--;
        }
        //若有cyclic，queue中会断掉一层
        return count == 0;
    }
}

//method2 BFS with hashset opitimization.
//即遇到了重复的边，只存一次。

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new HashSet<Integer>());
        }
        
        
        
        for (int i = 0; i < prerequisites.length; i++) {
            //用list去记录每一个出度对应的多个入度 [[1, 0]] 0->1
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
        }
        
        int[] countVertex = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> set = list.get(i);
            Iterator<Integer> ite = set.iterator();
            while (ite.hasNext()) {
                countVertex[ite.next()]++;
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            //find the course with zero pre-course
            for (; j < numCourses; j++) {
                if (countVertex[j] == 0) break;
            }
            //if not find the non-ore course
            if (j == numCourses) return false;
            
            //has been visited
            countVertex[j] = -1;
            
            //decrease courses that post the course
            HashSet<Integer> set = list.get(j);
            Iterator<Integer> ite = set.iterator();
            while (ite.hasNext()) {
                countVertex[ite.next()]--;
            }
        }
        return true;
    }
}

//method 3 DFS

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        //图的所有链接
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        Arrays.fill(visited, 0);
        for (int i = 0; i < numCourses; i++) {
            //whether each point could finish the dfs = no DAGs
            if (!dfs(list, visited, i)) return false;
        }
        return true;
    }
    
    private boolean dfs(List<List<Integer>> list, int[] visited, int i) {
        //有DAG
        if (visited[i] == -1) return false;
        //没有重复但已经判断过的点
        if (visited[i] == 1) return true;
        
        visited[i] = -1;
        for (int x : list.get(i)) {
            if (!dfs(list, visited, x)) return false;
        }
        visited[i] = 1;
        return true;
    }
}