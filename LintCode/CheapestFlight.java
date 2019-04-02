import java.util.*;

public class CheapestFlight {
	public static void main(String[] args) {
		int n = 4;
		int[][] flight = {
			{0,1,100},
			{1,2,100},
			{0,2,500},
			{2,3,300}
		};

		int src = 0;
		int end = 3;
		int k = 2;

		CheapestFlight cf = new CheapestFlight();
		int steps = cf.cheapestFlight(n, flight, src, end, k);
		System.out.println(steps);
	}

	public int cheapestFlight(int n, int[][] flight, int src, int end, int k) {

		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[src] = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		int step = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer city = queue.poll();
				for (int[] f : flight) {
					int fromCity = f[0];
					int nextCity = f[1];
					if (fromCity != city) continue;
					if (step == k && nextCity != end) continue;
					if (cost[fromCity] + f[2] < cost[nextCity]) {
						cost[nextCity] = cost[fromCity] + f[2];
						queue.offer(nextCity);
					}
				}
			}
			step++;
		}

		return cost[end] == Integer.MAX_VALUE ? -1 : cost[end];
	}
}


// 0 1 100
// 1 2 100
// 0 2 500
// src = 0, dst = 2 -> 200 -> k = 1