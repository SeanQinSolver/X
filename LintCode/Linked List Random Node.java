/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    ListNode head;
    Random random;
    
    /** @param head The linked list's head.
     Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode move = head;
        int curr = move.val;
        for (int i = 1; move.next != null; i++) {
            move = move.next;
            if (getRandom(0, i) == i) {
                curr = move.val;
            }
        }
        return curr;
    }
    private int getRandom(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }
}
http://blog.jobbole.com/42550/
https://discuss.leetcode.com/topic/55049/java-solution-with-cases-explain
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */