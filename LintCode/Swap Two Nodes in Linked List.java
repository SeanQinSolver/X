/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null) return head;
        //if (v1 == v2) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev1 = findPrev(head, v1);
        
        ListNode prev2 = findPrev(head, v2);
        
        //System.out.println(prev1.val + " " + prev2.val);
        
        if (prev1 == null || prev2 == null) return head;
        if (prev1 == prev2) return head;
        //corner case :10->8->7->6->4->3->null, 8, 10
        if (prev1.val == dummy.val) {
            dummy = prev1;
        }
        //corner case: 10->8->7->6->4->3->null, 8, 10
        if (prev2.val == dummy.val) {
            dummy = prev2;
        }
        
        if (prev1.next == prev2) {
            swapNear(prev1.next, prev2.next, prev1);
        }
        else if (prev2.next == prev1) {
            swapNear(prev2.next, prev1.next, prev2);
        }
        else {
            swapRemote(prev1, prev2, prev1.next, prev2.next);
        }
        //System.out.println(dummy.next.val);
        return dummy.next;
    }
    
    private ListNode findPrev(ListNode head, int v) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (dummy.next != null) {
            if (dummy.next.val == v) {
                return dummy;
            }
            dummy = dummy.next;
        }
        return null;
    }
    
    private void swapNear(ListNode node1, ListNode node2, ListNode pre1) {
        ListNode temp = node2.next;
        pre1.next = node2;
        node2.next = node1;
        node1.next = temp;
        //System.out.print(node1.val + "  " + node2.val);
    }
    
    private void swapRemote(ListNode prev1, ListNode prev2, ListNode node1, ListNode node2) {
        ListNode post1 = node1.next;
        ListNode post2 = node2.next;
        prev1.next = node2;
        node2.next = post1;
        prev2.next = node1;
        node1.next = post2;
    }
}