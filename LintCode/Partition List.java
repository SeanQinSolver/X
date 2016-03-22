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
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode n = head;
        //ListNode n2 = head;
        ListNode dummyLeft = new ListNode(0);
        ListNode fixLeft = dummyLeft;
        ListNode dummyRight = new ListNode(0);
        ListNode fixRight = dummyRight;
        while (n != null) {
            if (n.val < x) {
                dummyLeft.next = n;
                dummyLeft = dummyLeft.next;
            } else {
                dummyRight.next = n;
                dummyRight = dummyRight.next;
            }
            n = n.next;
        }
        
        dummyLeft.next = fixRight.next;
        dummyRight.next = null;
        
        return fixLeft.next;
    }
}

//此题运用四个指针，两个一个动。两个在dummy处不动。最后在把小的尾巴和大的头相接
