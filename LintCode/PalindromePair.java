// ["abcd","dcba","lls","s","sssll"]
// [[0,1],[1,0],[3,2],[2,4]] 
// ["dcbaabcd","abcddcba","slls","llssssll"]
// s ll s
// ss sll
import java.util.*;

public class PalindromePair {

	public static void main(String[] args) {
		String[] strs = {"abcd","dcba","lls","s","sssll"};
		PalindromePair pp = new PalindromePair();
		ArrayList<Pair> list = pp.findPairs(strs);

		for (Pair p : list) {
			System.out.println("[" + p.start + " ," + p.end + "]");
		}
	}

	public ArrayList<Pair> findPairs(String[] strs) {
		if (strs == null || strs.length == 0) return null;

		ArrayList<Pair> list = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs.length; j++) {
				if (i == j) continue;
				if (isPalindrome(strs[i], strs[j])) {
					Pair p = new Pair(i, j);
					list.add(p);
				}
			}
		}
		return list;
	}

	private boolean isPalindrome(String s1, String s2) {
		String append = s1 + s2;
		int start = 0;
		int tail = append.length() - 1;
		while (start < tail) {
			if (append.charAt(start) != append.charAt(tail)) return false;
			start++;
			tail--;
		}
		return true;
	}

	private static class Pair {
		int start;
		int end;
		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}