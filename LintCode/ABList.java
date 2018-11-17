/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// The following iterative sequence is defined for the set of positive integers:

// n -> n / 2    (if n is even)
// n -> 3n + 1   (if n is odd)

// Using the rule above and starting with 13, we generate the following sequence:

// 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1

// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), 
// it is thought that all starting numbers finish at 1 (and for this interview you may assume this is correct).

// Which starting number, under 100k, produces the longest chain? We're looking for a reasonably efficient solution.

// 77031 generates the longest sequence of length 351
import java.util.*;


public class ABList {

	public static void main(String[] args) {
		ABList abl = new ABList();
		int res = abl.calLen();
		System.out.println(res);
	}

	public int calLen() {
		int len = 0;
		HashMap<Long, Integer> map = new HashMap<>();
		HashSet<Long> visited = new HashSet<>();
		for (long i = 2L; i < 100000L; i++) {
			len = Math.max(len, getLen(i, map, visited));
		}
		return len;
	}

	private int getLen(long i, HashMap<Long, Integer> map, HashSet<Long> visited) {
		//if (map.containsKey(i)) return map.get(i);
		if (visited.contains(i)) return -1;
		int count = 0;
		long num = i;
		int len = 0;
		Stack<Long> stack = new Stack<>();
		while (num != 1) {
			count++;
			if (!visited.contains(num)) {
				visited.add(num);
			}
			if (map.containsKey(num)) {
				return map.get(num) + count;
			}
			stack.push(num);
			if (num % 2 == 0) {
				num = num / 2;
			} else {
				num = num * 3 + 1;
			}
		}
		while (!stack.isEmpty()) {
			map.put(stack.pop(), ++len);
		}
		return count;
	}
}
