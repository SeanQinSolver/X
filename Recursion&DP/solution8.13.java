//solution1 without memoization
public class Solution {
	public int createStack(ArrayList<Box> boxes) {
		Collection.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}

	public createStack(ArrayList<Box> boxes, int bottomIndex) {
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		for (int i = bottomIndex + 1; i < boxes.size(); i++) {
			if (boxes.get(i).canBeAbove(bottom)) {
				int height = createStack(boxes, i);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		maxHeight += bottom.height;
		return maxHeight;
	}

	class BoxComparator implements Comparator<Box> {
		@Override
		public int compare(Box x, Box y) {
			return y.height - x.height;
		}
	}
}

//solution2 with memoization

public class Solution {
	public int createStack(ArrayList<Box> boxes) {
		Collections.sort(boxes, new BoxComparator());
		int maxHeight = 0;
		int[] stackMap = new int[boxes.size()];
		for (int i = 0; i < boxes.size(); i++) {
			int height = createStack(boxes, i, stackMap);
			maxHeight = Math.max(maxHeight, height);
		}
		return maxHeight;
	}
	class Box {
		String height;
		public Box(String height) {
			this.height = height;
		}
		public boolean canBeAbove(Box box) {
			return this.height - box.height < 0;
		}
	}
	public int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
		if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) return stackMap[bottomIndex];
		Box bottom = boxes.get(bottomIndex);
		int maxHeight = 0;
		for (int i = bottomIndex + 1; i < boxes.size(); i++) {
			if (box.get(i).canBeAbove(bottom)) {
				int height = createStack(boxes, i, stackMap);
				maxHeight = Math.max(height, maxHeight);
			}
		}
		maxHeight += bottom.height;
		stackMap[buttomIndex] = maxHeight;
		return maxHeight;
	}

	class BoxComparator implements Comparator<Box> {
		@Override
		public int compare(Box x, Box y) {
			return y.height - x.height;
		}
	}
}

//solution3 use cache 

public int createStack(ArrayList<Box> boxes) {
	Collections.sort(boxes, new BoxComparator());
	int[] stackMap = new int[boxes.size()];
	return createStack(boxes, null, 0, stackMap);
}

public int createStack(ArraList<Box> boxes, Box bottom, int offset, int[] stackMap) {
	if (offset >= boxes.size()) return 0;

	Box newBottom = boxes.get(offset);
	int heigthWithBottom = 0;
	if (bottom == null || newBottom.canBeAbove(bottom)) {
		if (stackMap[offset] == 0) {
			stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
			stackMap[offset] += newBottom.height;
		}
		heigthWithBottom = stackMap[offset];
	}

	int heigthWithOutBottom = createStack(boxes, bottom, offset + 1, stackMap);
	return Math.max(heigthWithBottom, heigthWithOutBottom);
}





