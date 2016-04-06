/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//此题注意两种找到Middl的指针
//一个是p1 = head, p2 = head.next ===> p2 != null && p2.next != null ==> p1 = p1.next, p2 = p2.next.next;
//一个是p1 = head, p2 = head ====> p2.next != null && p2.next.next != null ==>跟上面一样
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode node = findMiddle(head);
        node.next = reverse(node.next);
        ListNode p1 = head;
        ListNode p2 = node.next;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
    private ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) { 
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
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


//写法2


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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode start1 = head;
        ListNode middle = findMid(head);
        ListNode start2 = reverse(middle.next);
        while (start1 != null && start2 != null) {
            if (start1.val != start2.val) return false;
            if (start1.next == null && start2.next == null) {
                return true;
            }
            start1 = start1.next;
            start2 = start2.next;
        }
        return true;
    }
    private ListNode findMid(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
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