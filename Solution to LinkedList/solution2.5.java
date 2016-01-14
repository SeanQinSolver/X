//Solution1
public class Solution {
	public LinkedListNode addList(LinkedListNode m1, LinkedListNode m2, int carry) {
		if (m1 == null && m2 == null && carry == 0 ) return null;
		LinkedListNode result = new LinkedListNode();
		int value = carry;
		if(m1 != null) value += m1.data;
		if(m2 != null) value += m2.data;
		result.data = value % 10;
		if(m1 != null || m2 != null) {
			LinkedListNode more = addList(m1 == null ? null : m1.next,
											m2 == null ? null : m2.next,
											value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}
}

public class LinkedListNode {
	public Object data;
	public LinkedListNode next;
	public LinkedListNode() {   
	}
}
//Solution2
public class Solution {
	 
	class PartialSum {
		public LinkedListNode sum == null;
		public int carry = 0;
	}

	LinkedListNode addLists(LinkedListNode m1, LinkedListNode m2) {
		int len1 = length(m1);
		int len2 = length(m2);

		if (len1 < len2) m1 = padList(m1, len2 - len1);
		else m2 = padList(m2, len1 - len2);

		PartialSum sum = addListHelper(m1, m2);

		if (sum.carry == 0) return sum.sum;
		else LinkedListNode result = insertBefore(sum.sum, sum.carry);
		return result;
	}

	public PartialSum addListHelper(LinkedListNode m1, LinkedListNode m2) {
		if (m1 == null && m2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = addListHelper(m1.next, m2.next)；

		int val = sum.carry + m1.data + m2.data;

		LinkedListNode full_result = insertBefore(sum.sum, val % 10);

		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	public LinkedListNode padList(LinkedListNode m, int padding) {
		LinkedListNode head = m;
		for (int i = 0; i < padding; i++) {
			head = insertBefore(head, 0);
		}
		return head;
	}

	public LinkedListNode insertBefore(LinkedListNode list, int data) {
		LinkedListNode node = new LinkedListNode(data);
		if (list != null) node.next = list;
		return node;
	}
}