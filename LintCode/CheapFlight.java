import java.util.*;
public class CheapFlight {
	public int findCheapestFlight(int n, int[][] flight, int src, int dst, int K) {
		

		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		int count = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Integer curr = queue.poll();
				for (int[] f : flight) {
					int from = f[0];
					int to = f[1];
					if ((count == K && to != dst) || (from != curr)) continue;
					if (from == curr && cost[to] > cost[from] + f[2]) {
						cost[to] = cost[curr] + f[2];
						queue.offer(to);
					}
				}
			}
			count++;
		}
		return cost[dst];
	}

	public static void main(String[] args) {
		int[][] flight = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
		int src = 0;
		int dst = 2;
		int k = 1;
		int n = 3;



		CheapFlight cf = new CheapFlight();
		int rest = cf.findCheapestFlight(n, flight, src, dst, k);
		System.out.println(rest);

		int[][] flight2 = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
		src = 0;
		dst = 2;
		k = 0;
		n = 3;

		int rest1 = cf.findCheapestFlight(n, flight, src, dst, k);
		System.out.println(rest1);
	}	
}

// Cheapest/Fastest use BFS