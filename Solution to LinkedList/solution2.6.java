//solution 1
public class HeadAndTail {
	public LinkedListNode head;
	public LinkedListNode tail;
	public HeadAndTail(LinkedListNode h, LinkedListNode t) {
		head = h;
		tail = t;
	}
}

public boolean isPanlindrome(LinkedListNode head) {
	HeadAndTail reversed = reverse(head);
	LinkedListNode reversedHead = reversed.head;
	return isEqual(head, reversedHead);
}

public HeadAndTail reverse(LinkedListNode head) {
	if (head == null) return null;
	HeadAndTail ht = reverse(head.next);
	LinkedListNode cloneHead = head.clone();
	cloneHead.next = null;

	if (ht == null) return new HeadAndTail(cloneHead, cloneHead);

	ht.tail.next = cloneHead;
	return new HeadAndTail(ht.head, cloneHead);
}

public boolean isEqual(LinkedListNode one, LinkedListNode two) {
	LinkedListNode head1 = one;
	LinkedListNode head2 = two;

	while (head1 != null && head2 != null) {
		if (head1.data != head2.data) return false;
		head1 = head1.next;
		head2 = head2.next;
	}
	return head1 == null && head2 == null;
}

//solution 2
public class Solution {
	public boolean isPalindrome(LinkedListNode head) {
		LinkedListNode fast = head;
		LinkedListNode slow = head;

		Stack<Integer> stack = new Stack<Integer>();

		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast != null) slow = slow.next;

		while (slow != null) {
			int top = stack.pop().intValue();
			if (top != slow.data) return false;
			slow = slow.next;
		}
		return true;
	}
}
//solution 3 compare each element with n - 1 element
public class Solution {

	class Result {
		public LinkedListNode node;
		public boolean result;
	}

	public int lengthOfList(LinkedListNode n) {
		int size = 0;
		while (n != null) {
			size++；
			n = n.next;
		}
		return size;
	}

	public boolean isPalindrome(LinkedListNode head) {
		int length = lengthOfList(head);
		Result p = isPalindrome(head, length);
		return p.result;
	}

	public Result isPalindrome(LinkedListNode head, int length) {
		if (head == null || length <= 0) return new Result(head, true);
		else if (length == 1) return new Result(head.next, true);

		Result res = isPanlindrome(head.next, length - 2);
		//judge if it is not a Panlindrome on specific point
		if (!res.result || res.node == null) return res;
		//judge if tail and front are the same value
		res.result = (head.data == res.node.data);
               
		res.node = res.node.next;
		return res;
	}
}
