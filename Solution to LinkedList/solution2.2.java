//solution1
public class Solution {
	public int printKthNode(LinkedListNode head, int k) {
		if (head == null) return 0;
		int index = printKthNode(head.next, k) + 1;
		if (index == k){
			System.out.println(k + " th number is " + head.data);
		}
		return index;
	} 
}
//solution2
public class Solution {
	public LinkedListNode nthToLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		//move p1 k nodes.
		for (int i = 0; i < k; i++) {
			if (p1 == null) return null;
			p1 = p1.next;
		}
		//move p1 p2 untile p1 reach the end of the Linkedlist
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
}