public class Solution {
    public List<List<String>> findLadders(String start, String end,
                                          Set<String> dict) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        dict.add(start);
        dict.add(end);
        
        bfs(map, distance, start, end, dict);
        
        List<String> path = new ArrayList<String>();
        dfs(ladders, path, end, start, distance, map);
        
        return ladders;
    }
    
    
    private void dfs(List<List<String>> ladders, List<String> path, String crt, String start, Map<String, Integer> distance, Map<String, List<String>> map) {
        
        path.add(crt);
        
        if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
                    dfs(ladders, path, next, start, distance, map);
                }
            }
        }
        path.remove(path.size() - 1);
    }
    
    //用distance记录每一个点到start的距离
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }
        
        while (!queue.isEmpty()) {
            String crt = queue.poll();
            List<String> nextList = expand(crt, dict);
            for (String next : nextList) {
                System.out.println(next);
                map.get(next).add(crt);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(crt) + 1);
                    queue.offer(next);
                }
            }
        }
    }
    
    private List<String> expand(String crt, Set<String> dict) {
        List<String> expansion = new ArrayList<String>();
        
        for (int i = 0; i < crt.length(); i++) {
            char[] array = crt.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                array[i] = ch;
                String temp = String.valueOf(array);
                if (dict.contains(temp) && !expansion.contains(temp)) {
                    expansion.add(temp);
                }
            }
        }
        return expansion;
    }
}