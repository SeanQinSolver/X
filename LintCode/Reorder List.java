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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        ListNode mid = findMid(head);
        
        ListNode head2 = reverse(mid.next);
        mid.next = null;
        
        while (head != null && head2 != null) {
            //left
            ListNode temp = head.next;
            //right
            ListNode temp2 = head2.next;
            head.next = head2;
            head2.next = temp;
            head = temp;
            head2 = temp2;
        }
    }
    //find middle
    private ListNode findMid(ListNode head) {
        if (head == null) return null;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (pointer2.next != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        return pointer1;
    }
    //reverse the right half
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
