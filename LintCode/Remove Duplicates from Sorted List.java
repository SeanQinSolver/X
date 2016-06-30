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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}


//写法2

public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (dummy.next.next != null) {
            int temp = dummy.next.val;
            if (dummy.next.next.val == temp) {
                dummy.next.next = dummy.next.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }
}