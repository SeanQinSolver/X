// # you are give a binary tree, can you print the each node of the tree by the level

// For example:
//      7
//   1     2
//  2  3 4   5
//          6

// 7 1 2 2 3 4 5         
         
//          7
//         2 3
        
//  output: {{7},{1,2},{2,3,4,5},{6}}
 
//     7
//   1   2 
 
//  7 1 2 2 3 4 5 6 
//  0 1 2 3 4 5 6 7 
 
 
 // 1, 2 -> 1 ->0 2n+ 1 -> 1 / (n + 1) * 2 -> 2
 // 3 4 5 6 -> 3 ->1 2n + 1 = 3 /  -> 4
 // 7 -> 7 ->2 2n + 1 = 7

public class Solution {

	public static void main(Stringp[] args) {

	}


	public ArrayList<ArrayList<Integer>> parse(Node root) {
		if (root == null) return null;
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		flatten(root, list);
		process(list, result);
		return result;
	}

	private void flatten(Node root, ArrayList<Integer> list) {
		if (root == null) return;
		list.add(root);
		flatten(root.left, list);
		flatten(root.right, list);
	}

	private static class Node {
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value = value;
		}
	}
}