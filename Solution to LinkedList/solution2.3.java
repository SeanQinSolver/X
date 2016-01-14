public class Solution {
	public boolean delNode(LinkedListNode n) {
		if (n == null || n.next == null) return false;

		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
} 