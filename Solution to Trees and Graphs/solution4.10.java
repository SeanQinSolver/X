//method1
public class Solution {
	public boolean containsTree(TreeNode t1, TreeNode t2) {
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();

		getOrderString(t1, s1);
		getOrderString(t2, s2);

		return s1.indexOf(s2.toString()) != -1;
	}

	public void getOrderString(TreeNode t, String s) {
		if (node == null) {
			sb.append("X");
			return;
		}

		sb.append(t.data + " ");
		//use pre-order traversal with x node on the end to ensure the difference
		getOrderString(t.left, sb);
		getOrderString(t.right, sb);
	}
}

//method2

public class Solution {
	public boolean containsTree(TreeNode t1, TreeNode t2) {
		if（t2 == null) return true; //empty tree is subtree of any tree
		return subTree(t1, t2);·                                        
	}
	//t1是larger tree的root，看t1的哪一个node和t2的root相同
	public boolean subTree(TreeNode t1, TreeNode t2) {
		if (t1 == null) return false;
		else if (t1.data == t2.data && matchTree(t1, t2)) return true;
		return subTree(t1.right, t2) || subTree(t1.left, t2);                                                                     
	}
	//再看root下面的left, right相等不
	public booelan matchTree(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) return true;
		else if (t1 == null || t2 == null) return false;
		else if (t1.data != t2.data) return false;
		else return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
	}
}