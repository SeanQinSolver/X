public class Solution {
	public Integer sortAStack(Stack<Integer> stack) {
		Stack<Integer> helper = new Stack<Integer>();
		while (stack.peek() != null) {
			int current = stack.pop();
			while (helper.empty() && current > helper.peek()) {
				stack.push(helper.pop());
			}
			helper.push(current);
		}
		return helper.peek();
	}
}