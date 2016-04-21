/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = helper(l1, l2, carry);
        return temp;
    }
    
    //in this problem no need to reverse
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
    
    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        
        ListNode result = new ListNode(0);
        
        if (l1 != null) carry += l1.val;
        if (l2 != null) carry += l2.val;
        
        result.val = carry % 10;
        
        if (l1 != null || l2 != null) {
            ListNode nextNode = helper(l1 == null ? null : l1.next, l2 == null ? null : l2.next,
                                       carry >= 10 ? 1 : 0);
            result.next = nextNode;
        }
        return result;
    }
}