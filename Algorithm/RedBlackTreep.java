//Red-black BST operation
//left rotate
public Node rotate(Node h) {
	Node x = h.right;
	h.right = x.left;
	x.left = h;
	x.color = h.color;
	h.color = RED;
	return x;

}

//right rotate
public Node rotate(Node h) {
	Node x = h.left;
	h.left = x.right;
	x.right = h;
	x.color = h.color;
	h.color = RED;
	return x;

}