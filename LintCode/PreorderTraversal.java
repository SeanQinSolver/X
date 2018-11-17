import java.util.*;
public class PreorderTraversal {

	public List<Integer> PreorderTraversal(TreeNode node) {
		if (node == null) return new ArrayList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(node.val);
		List<Integer> left = PreorderTraversal(node.left);
		List<Integer> right = PreorderTraversal(node.right);
		list.addAll(left);
		list.addAll(right);
		return list;
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
		PreorderTraversal pt = new PreorderTraversal();
		List<Integer> result = pt.PreorderTraversal(node1);
		System.out.print("[");
		for (Integer i : result) {
			System.out.print(" " + i + ",");
		}
		System.out.println("]");
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
			left = null;
			right = null;
		}
	}
}

//  1
// 2 3


// 1 2 3 