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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                lastNode.next = p1;
                p1 = p1.next;
            } else {
                lastNode.next = p2;
                p2 = p2.next;
            }
            lastNode = lastNode.next;
        }
        if (p1 != null) {
            lastNode.next = p1;
        } else {
            lastNode.next = p2;
        }
        return dummy.next;
    }
}