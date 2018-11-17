import java.util.*;

public class NQueensTwo {

	private int count = 0;

	public static void main(String[] args) {
		NQueensTwo nqt = new NQueensTwo();
		nqt.solveNQueens(4);
	}

	private void solveNQueens(int n) {
		List<Integer> cols = new ArrayList<Integer>();
		search(n, cols);
		System.out.print("count: " + count);
	}

	private boolean isValid(int col, List<Integer> cols) {
		int row = cols.size();

		for (int i = 0; i < row; i++) {
			// same column
			if (cols.get(i) == col) return false;
			// up left to down right
			if (i - row == cols.get(i) - col) return false;
			// up right to down left
			if (i - row == col - cols.get(i)) return false;
		}
		return true;
	}

	private void search(int n, List<Integer> cols) {
		if (cols.size() == n) {
			count++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(col, cols)) continue;
			cols.add(col);
			search(n, cols);
			cols.remove(cols.size() - 1);
		}
	}
}