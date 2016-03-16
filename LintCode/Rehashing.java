/**
 * Definition for ListNode
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return new ListNode[0];
        }
        int newLen = hashTable.length * 2;
        ListNode[] newTable = new ListNode[newLen];
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                int newIndex = (hashTable[i].val % newLen + newLen) % newLen;
                if (newTable[newIndex] == null) {
                    newTable[newIndex] = new ListNode(hashTable[i].val);
                } else {
                    ListNode entry = newTable[newIndex];
                    while (entry.next != null) {
                        entry = entry.next;
                    }
                    entry.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newTable;
    }
};
