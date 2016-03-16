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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int size = getListLength(head);
        return buildTree(head, size);
    }
    private int getListLength(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
    private TreeNode buildTree(ListNode head, int size) {
        if (size <= 0) {
            return null;
        }
        if (size == 1) {
            return new TreeNode(head.val);
        }
        ListNode pointer = head;
        int count = 0;
        //获取中间的node, 然后左右遍历
        //若SIZE为4，则中间的0,1,2,3取位置2为中点.若5,则中间的取0,1,2,3,4取2为中点
        while (count < size / 2) {
            pointer = pointer.next;
            count++;
        }
        TreeNode left = buildTree(head, size / 2);
        TreeNode root = new TreeNode(pointer.val);
        TreeNode right = buildTree(pointer.next, size - 1 - size / 2);
        
        root.left = left;
        root.right = right;
        return root;
        
    }
}


// 在这种情况下我默默地打开了九章的参考代码，发现他们竟然没有用length / 2 - 1，而是length - 1 - length / 2. 立马意识到这两者可能并不相等。用错误数据试了下，长度为1或者3时两者即不相等。知道对于整型数来说，1 / 2为0，但是却没能活学活用，血泪的教训。:-( 一个美好的下午就没了。