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
        
        //把圈外的
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

//写法2
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
        if (headA == null || headB == null) return null;
        
        ListNode tailA = getTail(headA);
        tailA.next = headB;
        
        ListNode slow = headA;
        ListNode fast = headA;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        slow = headA;
        
        ListNode intersection = getIntesection(slow, fast);
        return intersection;
        
    }
    
    private ListNode getTail(ListNode headA) {
        while (headA.next != null) {
            headA = headA.next;
        }
        return headA;
    }
    
    private ListNode getIntesection(ListNode headA, ListNode headB) {
        while (true) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
    }
}

//