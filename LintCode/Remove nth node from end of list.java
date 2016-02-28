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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        //求出长度
        int count = 1;
        while (pointer1.next != null) {
            pointer1 = pointer1.next;
            count++;
        }
        //回到n点之前一点，若count == 0, 则在起点
        count = count - n;
        if (count == 0) {
            return head.next;
        }
        //若没在起点
        while (count - 1 > 0) {
            pointer2 = pointer2.next;
            count--;
        }
        ListNode pointertemp = pointer2.next.next;
        pointer2.next = pointertemp;
        return head;
    }
}


//method2, let the pointer2 move ahead of n steps

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
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while (n > 0) {
            pointer1 = pointer1.next;
            n--;
        }
        if (pointer1 == null) {
            return pointer2.next;
        }
        while (pointer2.next != null && pointer1.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        ListNode temp = pointer2.next.next;
        pointer2.next = temp;
        return head;
    }
}

