//method1, copy the tree into array then see the 
public class solution {
	int index = 0;
	public void copyBST(TreeNode root, int[] array) {
		if (root == null) return;
		copyBST(root.left, array);
		array[index] = root.data;
		index++;
		copyBST(root.right, array);
	}

	public boolean checkBST(TreeNode root) {
		int[] array = new int[root.size];
		copyBST(root, array);
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= array[i - 1]) return false;
		}
		return true;
	}
}

//method2. track the larger or smaller one while we are recursion

public class solution {
	Integer lastone = null;
	public boolean checkBST(TreeNode root) {
		if (root == null) return t
			rue;

		if (!checkBST(root.left)) return false;

		if (lastone != null && root.data <= lastone) {
			return false;
		}
		lastone = root.data;

		if (!checkBST(root.right)) return false;
		return true;
	}
}

//method3 Recursive check the left is smaller than root, right is larger than root.
public class solution {
	public boolean checkBST(TreeNode root) {
		return checkBST(root, null, null);
	}

	public boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) return true;

		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST(n.left, n.data, max) || !checkBST(n.right, min, n.data)) {
			return false;
		}
		return true;
	}
}