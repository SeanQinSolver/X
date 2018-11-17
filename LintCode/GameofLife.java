import java.util.*;

public class GameofLife {
	final int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	public static void main(String[] args) {
		int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
		GameofLife gof = new GameofLife();
		gof.gameOfLife(board);
	}
	public void gameOfLife(int[][] board) {
		if (board == null) return;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int neighbors = countNeighbors(i, j, board);
				if (board[i][j] == 1 && neighbors >= 2 && neighbors <= 3) {
					board[i][j] += 2;
				} else if (board[i][j] == 0 && neighbors == 3) {
					board[i][j] += 2;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] >>= 1;
			}
		}


		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

	}

	private int countNeighbors(int i, int j, int[][] board) {
		int lives = 0;
		for (int[] d : direction) {
			int newX = d[0] + i;
			int newY = d[1] + j;
			if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
			if (board[newX][newY] == 1 || board[newX][newY] == 3) lives++;
		}
		return lives;
	}
}

// any cell fewer than two live neighbors dies
// live cell with 2 - 3 neighbors lives on next gen
// live cell > 3 live neighbors dies
// any dead cell with exactly three live neighbors becomes a live cell.