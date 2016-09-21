/**
* Definition for ListNode.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int val) {
*         this.val = val;
*         this.next = null;
*     }
* }
*/
//method1 heap NLogN
public class Solution {
/**
 * @param lists: a list of ListNode
 * @return: The head of one sorted list.
 */
private Comparator<ListNode> newComparator = new Comparator<ListNode>() {
    public int compare(ListNode left, ListNode right) {
        if (left == null) {
            return 1;
        } else if (right == null) {
            return -1;
        }
        return left.val - right.val;
    }
};
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
        return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), newComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = tail.next;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;
    }
}

//method2 mergesort NlogN

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) return null;
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoList(left, right);
    }
    private ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                tail.next = node1;
                tail = tail.next;
                node1 = node1.next;
            } else {
                tail.next = node2;
                tail = tail.next;
                node2 = node2.next;
            }
        }
        if (node1 != null) {
            tail.next = node1;
        } else {
            tail.next = node2;
        }
        return dummy.next;
    }
}
