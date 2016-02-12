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
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        //让值相同然后让当前NODE跳过原有的NEXT,指向NEXT.NEXT
        ListNode temp = node.next.next;
        node.val = node.next.val;
        node.next = temp;
    }
}