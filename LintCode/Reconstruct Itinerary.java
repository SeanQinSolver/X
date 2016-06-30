public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        
        for (String[] string : tickets) {
            if (map.containsKey(string[0])) {
                map.get(string[0]).offer(string[1]);
                continue;
            }
            map.put(string[0], new PriorityQueue<String>());
            map.get(string[0]).offer(string[1]);
        }
        dfs("JFK", result, map);
        return result;
    }
    private void dfs(String s, List<String> result, Map<String, PriorityQueue<String>> map) {
        while (map.containsKey(s) && !map.get(s).isEmpty()) {
            String next = map.get(s).poll();
            dfs(next, result, map);
        }
        result.add(0, s);
    }
}