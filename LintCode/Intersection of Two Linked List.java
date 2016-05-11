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

//method2

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
    
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        while (p1.next != null) {
            p1 = p1.next;
        }
        //cyclic
        p1.next = headB;
        ListNode result = findCycle(headA);
        
        //去掉环形
        p1.next = null;
        return result;
        
    }
    private ListNode findCycle(ListNode head) {
        ListNode slow = head;
        //注意1：fast需要往前走一步
        ListNode fast = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        //注意2:此时fast需要再往前走一步。这样才能slow和fast指针相同步数到达交汇点
        fast = fast.next;
        
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

//find cyclic 写法2

private ListNode findCyclic(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (true) {
        if (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        if (fast == slow) break;
        } else {
            return null;
            }
        }


        slow = head;
        fast = fast.next;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
