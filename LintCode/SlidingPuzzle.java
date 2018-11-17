import java.util.*;
public class SlidingPuzzle {
	public static void main(String[] args) {
		int[][] board = {{1,2,3},{4,0,5}};
		SlidingPuzzle sp = new SlidingPuzzle();
		//int count = sp.slidingPuzzle(board);
		//System.out.println(count);
		int[][] board2 = {{4,1,2},{5,0,3}};
		int count2 = sp.slidingPuzzle(board2);
		System.out.println(count2);
	}
	public int slidingPuzzle(int[][] board) {
		if (board == null) return -1;

		String res = "123450";

		String s = "";
		for (int[] b : board) {
			for (int i : b) {
				s += i;
			}
		}
		System.out.println(s);
		// 

		int[][] move = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

		Queue<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<>();

		queue.offer(s);
		visited.add(s);

		int count = 0;

		while (!queue.isEmpty()) {
			int len = queue.size();
			while (len > 0) {
				String curr = queue.poll();
				if (curr.equals(res)) return count;
				int zero = curr.indexOf("0");
				for (int i = 0; i < move[zero].length; i++) {
					String next = switchIndex(move[zero][i], zero, curr);
					if (visited.contains(next)) continue;
					queue.offer(next);
					visited.add(next);
				}
				len--;
			}
			count++;
		}
		return -1;
	}

	private String switchIndex(int i, int j, String s) {
		char pos1 = s.charAt(i);
		char pos2 = s.charAt(j);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(j, pos1);
		sb.setCharAt(i, pos2);
		return sb.toString();
	}
}


// 123405

// 123450