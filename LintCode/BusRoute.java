import java.util.*;

public class BusRoute {
	public int busRoutes(int[][] routes, int start, int end) {
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		buildMap(map, routes);

		int count = bfs(map, routes, start, end);
		return count;
	}

	private int bfs(HashMap<Integer, Set<Integer>> map, int[][] routes, int start, int end) {
		// queue for maintaining the stop.
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.offer(start);
		Set<Integer> set = new HashSet<>();
		int count = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			count++;
			for (int i = 0; i < len; i++) {
				int startStop = queue.poll();
				Set<Integer> buses = map.get(startStop);
				for (Integer bus : buses){
					if (set.contains(bus)) continue;
					set.add(bus);
					for (int j = 0; j < routes[bus].length; j++) {
						if (routes[bus][j] == end) return count;
						queue.offer(routes[bus][j]);
					}
				}
			}
		}
		return count;
	}

	private void buildMap(HashMap<Integer, Set<Integer>> map, int[][] routes) {
		for (int i = 0; i < routes.length; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				Set<Integer> set = map.getOrDefault(routes[i][j], new HashSet<Integer>());
				set.add(i);
				map.put(routes[i][j], set);
			}
		}
	}

	public static void main(String[] args) {
		int[][] routes = {{1, 2, 7}, {3, 6, 7}};
		int start = 1;
		int end = 6;
		BusRoute br = new BusRoute();
		int res = br.busRoutes(routes, start, end);
		System.out.println(res);
	}
}





// Example:
// Input: 
// routes = [[1, 2, 7], [3, 6, 7]]
// S = 1
// T = 6
// Output: 2
// Explanation: 
// The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.


// 建一个map bus -> stop