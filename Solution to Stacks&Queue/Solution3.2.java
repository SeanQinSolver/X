//Solution1
public class Solution {
	public int getMinFromStack(Stack stack) {
		Stack<Integer> helper = new LinkedList<Integer>();
		while (!stack.empty()) {
			int current = helper.pop();
			while (!helper.empty() && current > helper.peek()) {
				stack.push(helper.pop());
			} 
			helper.push(current);
		}
		return helper.peek();
	}
}

//Solution2 store the min in a sepeate NodesWithMin
public class StackWithMin extends Stack<NodesWithMin>{

	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodesWithMin(value, min));
	}

	public void min() {
		if (this.empty()) {
			return Integer.MAX_VALUE;
		} else {
			return peek().min; 
		}
	}
}
class NodesWithMin {
	private int value;
	private int min;
	public NodesWithMin() {
		this.value = value;
		this.min = min;
	}
}

//Solution3 Additional stack to hold the data
public class StackWithMin extends Stack<Integer> {
	Stack<Integer> s2;
	public StackWithMin() {
		s2 = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == min()) {
			s2.pop();
		}
		return value;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}