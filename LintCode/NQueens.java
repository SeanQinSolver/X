import java.util.*;

public class NQueens {
	public static void main(String[] args) {
		 NQueens nq = new NQueens();
		 List<List<String>> res = nq.solveNQueuens(4);

		 for (List<String> r : res) {
		 	for (String s : r) {
		 		System.out.println(s);
		 	}
		 }
	}

	private List<String> draw(ArrayList<Integer> cols) {
		List<String> chess = new ArrayList<>();
		for (int i = 0; i < cols.size(); i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < cols.size(); j++) {
				if (cols.get(i) == j) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			chess.add(sb.toString());
		}
		return chess;
	}

	public List<List<String>> solveNQueuens(int n) {
		List<List<String>> result = new ArrayList<>();
		if (n <= 0) return result;
		ArrayList<Integer> cols = new ArrayList();
		search(n, cols, result);
		return result;
	}

	private boolean isValid(ArrayList<Integer> cols, int col) {
		int row = cols.size();

		for (int i = 0; i < row; i++) {
			// same column
			if (cols.get(i) == col) return false;
			if (Math.abs(i - row) == Math.abs(cols.get(i) - col)) return false;
		}
		return true;
	} 

	private void search(int n, ArrayList<Integer> cols, List<List<String>> result) {
		if (cols.size() == n) {
			result.add(draw(cols));
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isValid(cols, col)) continue;
			cols.add(col);
			search(n, cols, result);
			cols.remove(cols.size() - 1);
		}
	}
}