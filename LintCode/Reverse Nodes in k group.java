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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head.next != null) {
            head = reverseGroup(head, k);
        }
        return dummy.next;
    }
    
    private ListNode reverseGroup(ListNode head, int k) {
        ListNode node = head;
        int copy_k = k;
        while (k > 0) {
            if (node.next == null) {
                return node;
            }
            node = node.next;
            k--;
        }
        //此题注意这里
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode cur1 = cur;
        while (copy_k > 0) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            copy_k--;
        }
        
        head.next = prev;
        cur1.next = cur;
        return cur1;
    }
}