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
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
    public int compare(ListNode left, ListNode right) {
    if (left == null) {
    return 1;
} else if (right == null) {
return -1;
}
return left.val - right.val;
}
};

public ListNode mergeKLists(List<ListNode> lists) {
if (lists == null || lists.size() == 0) {
return null;
}

Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);

for (int i = 0; i < lists.size(); i++) {
if (lists.get(i) != null) {
heap.add(lists.get(i));
}
}


ListNode dummy = new ListNode(0);
ListNode tail = dummy;
while (!heap.isEmpty()) {
ListNode head = heap.poll();
tail.next = head;
tail = head;
if (head.next != null) {
heap.add(head.next);
}
}

// while (!heap.isEmpty()) {
//     System.out.print(heap.poll() + "->");
// }
return dummy.next;
}
}

//Method2 heap in PriorityQueue see in github





//merge sort
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //NlogN
    
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    
    private ListNode helper(ListNode[] lists, int i, int j) {
        if (i > j) return null;
        if (i == j) return lists[i];
        int mid = i + (j - i) / 2;
        ListNode left = helper(lists, i, mid);
        ListNode right = helper(lists, mid + 1, j);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode t1, ListNode t2) {
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                move.next = t1;
                t1 = t1.next;
            } else {
                move.next = t2;
                t2 = t2.next;
            }
            move = move.next;
        }
        
        if (t1 != null) {
            move.next = t1;
        }
        if (t2 != null) {
            move.next = t2;
        }
        return dummy.next;
    }
}
