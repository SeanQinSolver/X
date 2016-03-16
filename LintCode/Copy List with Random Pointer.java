/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode curr = dummy;
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            curr.next = newNode;
            map.put(head, newNode);
            //将新节点的RANDOM指向以前的RANDOM所指向的节点。新旧交叉
            newNode.random = head.random;
            head = head.next;
            curr = curr.next;
        }
        curr = dummy.next;
        while (curr != null) {
            if (curr.random != null) {
                //获取
                RandomListNode node = map.get(curr.random);
                curr.random = node;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
