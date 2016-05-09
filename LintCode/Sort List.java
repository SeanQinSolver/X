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
//merge sort
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode right = sortList(mid.next);
        //将左右分离
        mid.next = null;
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    //when find middle, set slow = fast = head, 那么while中应该判断fast.next 与fast.next.next
    //若设置fast = head.next, slow = head。那么while中判断fast与fast.next
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }
        if (n1 != null) {
            tail.next = n1;
        } else {
            tail.next = n2;
        }
        return dummy.next;
    }
}

//Quict sort1

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(0);
        ListNode leftMove = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightMove = rightDummy;
        ListNode middleDummy = new ListNode(0);
        ListNode middleMove = middleDummy;
        
        ListNode mid = findMid(head);
        
        while (head != null) {
            if (head.val < mid.val) {
                leftMove.next = head;
                leftMove = leftMove.next;
            } else if (head.val > mid.val) {
                rightMove.next = head;
                rightMove = rightMove.next;
            } else {
                middleMove.next = head;
                middleMove = middleMove.next;
            }
            head = head.next;
        }
        
        leftMove.next = null;
        rightMove.next = null;
        middleMove.next = null;
        
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concate(left, middleDummy.next, right);
        
    }

    private ListNode concate(ListNode t1, ListNode t2, ListNode t3) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = t1;
        tail = getTail(tail);
        tail.next = t2;
        tail = getTail(tail);
        tail.next = t3;
        
        return dummy.next;
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    
    private ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

//Quict sort2


