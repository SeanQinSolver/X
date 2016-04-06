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
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        int carry = 0;
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode temp = helper(l1, l2, 0);
        return reverse(temp);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int value = carry;
        ListNode result = new ListNode(0);
        if (l1 != null) value += l1.val;
        if (l2 != null) value += l2.val;
        result.val = value % 10;
        if (l1 != null || l2 != null) {
            ListNode more = helper(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    } 
}

//此题的重点是翻转两根LINKEDLIST，从首加到尾在翻转。加的时候有个carry来carry进位

//进位注意判断value >= 10有个等于哈！