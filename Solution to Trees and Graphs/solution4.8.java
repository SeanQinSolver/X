//method 1
public class Solution {
	public TreeNode commonAcenstor(TreeNode p, TreeNode q) {
		int delta = depth(p) - depth(q);
		TreeNode first = delta > 0 ? q : p; //first为小的
		TreeNode second = delta > 0 ? p : q; //second为大的
		second = goUpBy(second, delta); //将second与first弄成一样的depth


		while (first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		return first == null || second == null ？ null : second;
	}



	public TreeNode goUpBy(TreeNode node, int delta) {
		while (delta > 0 && node != null) {
			node = node.parent;
			delta--;
		}
		return node;
	}
	public int depth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}
} 

//method2

public class Solution {

	public TreeNode commonAcenstor(TreeNode root, TreeNode p, TreeNode q) {
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}
	}

	TreeNode silibing = getSilibing(q);
	TreeNode parent = q.parent;

	while (!covers(silibing, p)) {
		silibing = getSilibing(parent);
		parent = parent.parent;
	}

	public boolean covers(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}

	public TreeNode getSilibing (TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}

		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}
} 

//method3 without links to parent, just check if q/p is covered in root.                                                                                        

public class Solution {

	public TreeNode commonAcenstor(TreeNode root, Treenode p, Treenode q) {
		if (!covers(root, q) || !covers(root, p)) {
			return null;
		}
		return ancestorHelper(root, p, q);
	}

	public TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		//Nodes are on different sides
		if (pIsOnLeft != qIsOnLeft) {
			return root;
		}
		//Nodes are on same side
		Treenode childSide = pIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, p, q);
	}

	public boolean covers(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}

}

//method4

