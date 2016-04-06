/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
        }
        return p1;
    }
}