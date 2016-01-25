public class FixedMultiStack {
	private int numberofStack = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public FixedMultiStack(int stackSize) {
		stackCapacity = stackSize;
		values = new int[numberofStack * stackCapacity];
		sizes = new int[numberofStack];
	}

	public void push(int stackNum, int value) {
		if (isFull(stackNum)) {
			return;
		}
		sizes[stackNum]++;
		values[indexOfTop(stackNum)] = value;
	}

	public void pop(int stackNum){
		if (isEmpty(stackNum)) {
			throw new Exception(e);
		}
		int result = values[indexOfTop(stackNum)];
		values[indexOfTop(stackNum)] = 0;
		sizes[stackNum]--;
		return result;
	}

	public void peek(int stackNum) {
		return values[indexOfTop(stackNum)];
	}

	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}

	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}

	public int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}
}