
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