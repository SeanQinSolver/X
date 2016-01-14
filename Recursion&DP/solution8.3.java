//brutal
public class Solution {
	public int getMagic(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == i){
				return i;
			}
		}
		return -1;
	}
}

//method2 binary search

public class Solution {
	public int getMagic(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}

	public int magicFast(int[] array, int start, int end) {
		if (end < start) return -1;

		int mid = end + start / 2;

		if (array[mid] == mid) return mid;
		else if (array[mid] < mid) return magicFast(array, mid + 1, end);
		else  return magicFast(array, start, mid + 1);
	}
}

//method3 if array contains duplicates

public class Solution {

	public int getMagic(int[] array) {
		return magicFast(array, 0, array.length - 1);
	}
	public int magicFast(int[] array, int start, int end) {
		if (end < start) return -1;
		int midIndex = start + end / 2;
		int midValue = array[midIndex];

		if (midValue == midIndex) return midIndex;
		
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) return left;

		int rightIndex = Math.max(mideIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);

		return right;
	}
}

