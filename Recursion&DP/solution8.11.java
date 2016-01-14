//solution1 with duplicates
public class Solution {
	public int makeChange(int amount, int[] denoms, int index) {
		if (index >= demons.length - 1) return 1;
		int denomAmount = demons[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1);
		}
		return ways;
	}

	public int makeChange(int n) {
		int[] denoms = {25, 10, 5, 1}
		return makeChange(n, denoms, 0);
	}
}
//solution2 without duplicates
public class Solution {
	public int makeChange(int n) {
		int[] denoms = {25, 10, 5, 1}
		int[][] map = new int[n + 1][denoms.length];
		return makeChange(n, denoms, 0, map);
	}

	public int makeChange(int amount, int[] denoms, int index, int[][] map) {
		if(map[amount][index] > 0) return map[amount][index];
		if(index >= denoms.length - 1) return 1;
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
}