
public class RotateList {
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode h = rl.rotate(n1, 2);
		while (h != null) {
			System.out.print(h.value);
			h = h.next;
		}
	}

	private int calLen(ListNode head) {
		int n = 0;
		while (head != null) {
			head = head.next;
			n++;
		}
		return n;
	}


	public ListNode rotate(ListNode head, int n) {
		if (head == null) return head;

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode tail = dummy.next;

		int len = calLen(head);
		n = n % len;

		for (int i = 1; i <= n; i++) {
			head = head.next;
		}

		while (head.next != null) {
			head = head.next;
			tail = tail.next;
		}

		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		return dummy.next;

	}

	private static class ListNode {
		int value;
		ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
	}
}

// 1->2->3->4->5-> NUll K = 2
// 4->5->1->2->3-> NUll

// 4->5 1->2->3


