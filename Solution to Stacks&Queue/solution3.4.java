//Solution3.4  注意的是stack2有T的时候加东西必须把stack2所有放入在放出

public class MyQueue<T> {
	private Stack<T> stack1;
	private Stack<T> stack2;

	public MyQueue() {
		stack1 = new Stack<T>();
		stack2 = new Stakc<T>();
	}

	public int size() {
		return stack1.size() + stack2.size();
	}

	public void add(T value) {
		while (stack2 != null) {
			stack1.push(stack2.pop());
		}
		stack1.push(value);
	}

	private T peek() {
		while (stack1 != null) {
			stack2.push(stack1.pop());
		}
		return stack2.peek();
	}

	private T remove() {
		while (stack1 != null) {
			stack1.push(stack1.pop());
		}
		return stakc2.pop();
	}
}