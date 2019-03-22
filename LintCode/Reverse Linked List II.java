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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        ListNode p1 = dummy;
        
        for (int i = 1; i < m; i++) {
            p1 = p1.next;
        }
        //此时P1在m前一个
        ListNode prev = null;
        ListNode curr = p1.next;
        while (curr != null && (m <= n)) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            m++;
        }
        //此时curr在5， p1指向1
        p1.next.next = curr;
        p1.next = prev;
        
        return dummy.next;
    }
}

//翻转后1->2<-3<-4->5
//p1此时指向1. curr指向5.
//先P1.next.next = curr
//再P1.next = prev；
// 1->4->3->2->5

// One path

public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode move = dummy;

        ListNode curr = null;
        ListNode prev = null;

        int index = 1;
        int copy_m = m;
        while (m <= n) {
            if (index < copy_m) {
                move = move.next;
                index++;
            } else if (index == copy_m) {
                curr = move.next;
                index++;
            } else {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp; 
                m++;
            }
        }

        move.next.next = curr;
        move.next = prev;

        return dummy.next;
    }
}
