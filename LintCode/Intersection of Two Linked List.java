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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
     
    class Data {
        int size;
        ListNode tail;
        public Data(int size, ListNode tail) {
            this.size = size;
            this.tail = tail;
        }
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headB == null || headA == null) {
            return null;
        }
        Data dA = getSizeTail(headA);
        Data dB = getSizeTail(headB);
        
        if (dA.tail != dB.tail) {
            return null;
        }
        
        ListNode longer = dA.size > dB.size ? headA : headB;
        ListNode shorter = dA.size < dB.size ? headA : headB;
        ListNode longerChop = chopTheLinkedList(Math.abs(dA.size - dB.size), longer);
        
        
        while (longerChop != shorter) {
            longerChop = longerChop.next;
            shorter = shorter.next;
        }
        return shorter;
    }
    
    private Data getSizeTail(ListNode node) {
        int count = 0;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        return new Data(count, node);
    }
    
    private ListNode chopTheLinkedList(int k, ListNode head) {
        while (k > 0 && head.next != null) {
            head = head.next;
            k--;
        }
        return head;
    }
}
