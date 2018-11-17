import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeList {

    private Comparator<ListNode> comp = new Comparator<ListNode>(){

        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }


    public ListNode merge(ListNode[] lists) {
        if (lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size, comp);

        for (ListNode node : lists) {
            pq.offer(node);
        }

        ListNode dummy = null;
        ListNode move = dummy;

        while (!pq.isEmpty()) {
            ListNode n = pq.poll();
            if (n.next != null) {
                pq.offer(n.next);
            }
            move.next = n;
            move = move.next;
        }
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}