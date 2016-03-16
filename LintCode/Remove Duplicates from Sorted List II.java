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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        while (pointer.next != null && pointer.next.next != null) {
            if (pointer.next.val == pointer.next.next.val) {
                int val = pointer.next.val;
                while (pointer.next != null && pointer.next.val == val) {
                    pointer.next = pointer.next.next;
                }
            } else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }
}

//此题注意删除的
