import java.util.*;

public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		List<Integer> res = sm.spiralOrder(matrix);

		for (Integer i : res) {
			System.out.print(i + " -> ");
		}
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null) return null;

		int m = matrix.length;
		int n = matrix[0].length;
		int totalLen = Math.multiplyExact(m, n);

		List<Integer> result = new ArrayList<>();
		int[] move = {0, 0};
		int direction = 0; // RIGHT FIRST
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < totalLen; i++) {
			result.add(matrix[move[0]][move[1]]);
			visited[move[0]][move[1]] = true;
			int[] next = Direction.move(move, direction);
			//System.out.println(next[0] + " " + next[1]);
			if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m || visited[next[0]][next[1]]) {
				direction = Direction.turn(direction);
				next = Direction.move(move, direction);
			}
			move = next;
		}
		return result;
	}

	private static class Direction {
		final int RIGHT = 0;
		final int DOWN = 1;
		final int UP = 2;
		final int LEFT = 3;

		static int[] dx = {0, 1, -1, 0};
		static int[] dy = {1, 0, 0, -1};

		public static int turn(int direction) {
			switch (direction) {
				case 0:
					return 1;
				case 1:
				    return 3;
				case 2:
				    return 0;
				case 3:
				    return 2;
				default:
				    return -1;
			}
		}

		public static int[] move(int[] pos, int direction) {
			int newX = pos[0] + dx[direction];
			int newY = pos[1] + dy[direction];
			return new int[]{newX, newY};
		}
	}
}


// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]