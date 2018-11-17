public class PaintHouse {
	public static void main(String[] args) {
		int[][] array = {{15, 6, 18}, {2, 4, 1}, {3, 1, 3}};
		PaintHouse ph = new PaintHouse();
		int res = ph.paint(array);
		System.out.println(res);
	}
	public int paint(int[][] costs) {
		if (costs == null || costs.length == 0) return -1;
		int len = costs.length;
		int len1 = costs[0].length;
		int[][] dp = new int[len][len1];
		helper(dp, costs);
		int min = Integer.MAX_VALUE;
		for (int value : dp[len - 1]) {
			min = Math.min(value, min);
		}
		return min;
	}
	private void helper(int[][] dp, int[][] costs) {
		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];


		for (int i = 1; i < costs.length; i++) {
			dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
	}
}