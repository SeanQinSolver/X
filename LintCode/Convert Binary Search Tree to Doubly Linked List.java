
class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
  }

 class DoublyListNode {
      int val;
      DoublyListNode next, prev;
     DoublyListNode(int val) {
          this.val = val;
          this.next = this.prev = null;
      }
  }


public class Test {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode  bstToDoublyList(TreeNode root) {
         if (root == null) {
             return new DoublyListNode(0);
         }
         root = helperDoublyList(root);
         while (root.right != null) {
                root = root.right;
         }
         DoublyListNode db = new DoublyListNode(root.val);
         while (root.left != null) {
                DoublyListNode db1 = new DoublyListNode(root.left.val);
                db1.next = db;
                db.prev = db1;
                root = root.left;
                db = db1;
         } 
        return db;
    }
    
    public TreeNode helperDoublyList(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            TreeNode leftNode = helperDoublyList(node.left);
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = node;
            node.left = leftNode;
        }
        if (node.right != null) {
            TreeNode rightNode = helperDoublyList(node.right);
            while (rightNode.left != null) {
                rightNode = rightNode.left;
            }
            rightNode.left = node;
            node.right = rightNode;
        }     
        return node;
    }
    
    
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        
        Test s = new Test();
        DoublyListNode d = s.bstToDoublyList(t1);
        while (d != null) {
            System.out.println(d.val);
            d = d.next;
        }
    }
}

//method2
用Stack

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        stack.push(node);
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode dNode = dummy;
        while (!stack.isEmpty()) {
            while (node != null && node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            node = stack.pop();
            DoublyListNode curr = new DoublyListNode(node.val);
            dNode.next = curr;
            curr.prev = dNode;
            dNode = dNode.next;
            
            //{2,3,#,4,#,5,#,6,#,7,#,8,#,9,#,11} 此处注意要强行node = node.right。
            //在node等于9的时候，11-><-9为已连接的doublylinkedlist. 转到循环while(node != null && node.left != null)依然可以进入循环，则又把9的left 11 push到stack中，就一直上下上下的走
            
            node = node.right;
            if (node != null) {
                stack.push(node);
            }
        }
        return dummy.next;
    }
}




