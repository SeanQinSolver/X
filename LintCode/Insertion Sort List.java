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
//method best runntime O(n)

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val < cur.val) {
                ListNode temp = dummy;
                while (temp.next != null && temp.next.val < cur.next.val) {
                    temp = temp.next;
                }
                ListNode change = temp.next;
                temp.next = cur.next;
                //必须放这里不然就是死循环的linkedlist
                cur.next = cur.next.next;
                temp.next.next = change;
                
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}


//Method2 时间复杂度N2, 空间复杂度O(1)
//这种方法是temp为指针重新连接并构建Linkedlist，内部每次都要从dummy开始遍历
public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode cur = head;
    while (cur != null) {
        ListNode prev = dummy;
        while (prev.next != null && prev.next.val < cur.val) {
            prev = prev.next;
        }
        ListNode temp = cur.next;
        cur.next = prev.next;
        prev.next = cur;
        cur = temp;
    }
    return dummy.next;
}