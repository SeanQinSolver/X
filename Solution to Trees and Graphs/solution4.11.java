//brutal
public class Solution {
	ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
	


	public void transtoArr(TreeNode n) {
		while (n != null) {
			arr.add(n.data);
			transtoArr(n.left);
			transtoArr(n.right);
		}
		return arr;
	}

	//o(n) time and space

	public TreeNode getRandom(arr) {
		int temp = Math.random() * arr.length();
		return arr[temp];
	}
}

//better method

public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	private int size = 0;

	public TreeNode(int d) {
		data = d;
		size = 1;
	}

	public TreeNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size();
		Random random = new Random();
		int index = random.nexInt(size);
		//左树大取左边的
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}

	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) left = new TreeNode(d);
			else left.insertInOrder(d);
		} else {
			if (right == null) right = new TreeNode(d);
			else rigth.insertInOrder(d);
		}
		size++;
	}

	public int size() {return size;}
	public int data() {return data;}

	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d <= data){
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;

	}










}