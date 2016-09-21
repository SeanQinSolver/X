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


//method2

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        return helper(l1, l2, 0);
    }
    private ListNode helper(ListNode l1, ListNode l2, int carry) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while (l1 != null && l2 != null) {
            sum += carry;
            if (l1 != null) {
                sum += l1.val;
            }
            if (l2 != null) {
                sum += l2.val;
            }
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            dummy.next = newNode;
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
            sum = 0;
        }
        while (l1 != null) {
            ListNode newNode = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            dummy.next = newNode;
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            ListNode newNode = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            dummy.next = newNode;
            dummy = dummy.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return move.next;
    }
}