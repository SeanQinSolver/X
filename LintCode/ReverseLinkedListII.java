public class ReverseLinkedListII {

    public ListNode reverseFromMToN(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode move = dummy.next;

        ListNode curr = null;
        ListNode prev = null

        int index = 1;
        int copy_m = m;
        while (m <= n) {
            if (index < m) {
                move = move.next;
                index++;
            } else if (index == m) {
                curr = move;
                index++;
            } else {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp; 
            }
        }

        move.next.next = curr;
        move.next = prev;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        Solution s = new Solution();

        ListNode head = s.reverseFromMToN(n1, 1, 1);

        while (head != null) {
          System.out.print(head.val + " -> ");
          head = head.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}