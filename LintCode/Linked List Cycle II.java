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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.nextQ.next;
                if (slow == fast) {
                    break;
                }
            } else {
                return null;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode inter = findInter(head);
        if (inter == null) return null;
        
        ListNode start1 = head;
        ListNode start2 = inter;
        while (start1.next != null && start2.next != null) {
            start1 = start1.next;
            start2 = start2.next;
            if (start1 == start2) return start1;
        }
        return null;
    }
    
    private ListNode findInter(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) return p1;
        }
        return null;
    }
    
}

