//solution1
public class Solution {
	public LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterend = null;

		//partition list
		while (node != null) {
			LinkedListNode next = node.next;

			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					boforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}

		if (beforeStart == null) return afterStart;

		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
//solution 2
public class Solution {
	public LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;                                                            
		}
		tail.next = null;
		return head;
	}
}




