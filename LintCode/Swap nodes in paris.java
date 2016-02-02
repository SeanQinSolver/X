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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode point = new ListNode(0);
        point.next = head;
        head = point;
        
        while (point.next != null && point.next.next != null) {
            ListNode t1 = point.next;
            ListNode t2 = point.next.next;
            //swap the node
            point.next = t2;
            t1.next = t2.next;
            t2.next = t1;
            //remove to next pair
            point = t1;
        }
        return head.next;
    }
}