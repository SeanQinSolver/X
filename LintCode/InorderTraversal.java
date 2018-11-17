import java.util.*;
public class InorderTraversal {

	public List<Integer> inorderTraversal(TreeNode node) {
		ArrayList<Integer> result = new ArrayList<>();
		if (node == null) return result;

		helper(node, result);
		return result;
	}

	private void helper(TreeNode node, ArrayList<Integer> list) {
		if (node == null) return;
		helper(node.left, list);
		list.add(node.val);
		helper(node.right, list);
		return;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node2.left = node6;
        node3.left = node5;
        InorderTraversal it = new InorderTraversal();
        List<Integer> result = it.inorderTraversal(node1);
        System.out.print("[");
        for (Integer i : result) {
        	System.out.print( " " + i + ",");
        }
        System.out.println("]");
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
}


//   1 
//  2 3
//4 5 6 7

// 4 2 5 1 6 3 7

