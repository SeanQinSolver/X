//solution1 buffer allowed
public class Solution {
	public void deleteDup(LinkedListNode n) {
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while(n != null) {
			if (set.contains(n.data)) {
				previous.next = n.next;
			} else { 
				set.add(n.data);
				previous = next;
			}
			n = n.next;
		}
	}
}
//solution2, code runs O(1) space, but o(N2) time

public class Solution {
	public void deleteDup(LinkedListNode head) {
		LinkedListNode current = head;
		while (current != null) {
			LinkedListNode runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}