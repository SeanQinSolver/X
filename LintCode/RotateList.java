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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        
        ListNode temp = head;
        int count = 0;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        
        if (count < k) {
            return head;
        }
        
        ListNode p1 = head;
        ListNode dummy = new ListNode(0);
        
        int count1 = count - k;
        while (count1 > 0 && p1.next != null) {
            p1 = p1.next;
            count1--;
        }
        
        ListNode p2 = p1.next;
        dummy.next = p2;
        p1.next = null;
        
        while (p2.next != null) {
            p2 = p2.next;
        }
        
        p2.next = head;
        return dummy.next;
    }
}

//Method2

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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }   
        int length = getLength(head);
        n = n % length;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode tail = dummy;
        for(int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head.next != null) {
            tail = tail.next;
            head = head.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
            
        }
        return length;
    }
    
}