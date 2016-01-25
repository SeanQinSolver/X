//1 brutal solution o(nlogn)

public class Solution {
	public void sorValleyPeak(int[] array) {
		Arrays.sort(array);
		for (int i = 1; i < array.length; i += 2) {
			swap(array, i - 1, i);
		}
	}
	public void sway(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}

//2 Optimal Solution o(n)

public class Solution {
	public void sortValleyPeak(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			int biggerIndex = maxIndex(array, i - 1, i, i + 1);
			if (i != biggerIndex) {
				swap(array, i, biggestIndex);
			}
		}
	}

	public void sway(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public int maxIndex(int[] array, int a, int b, int c) {
		int len = array.length;
		int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
		int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE；
		int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE；

		int max = Math.max(aValue, Math.max(bValue, cValue));
		if (aValue == max) return a;
		else if (bValue == max) return b;
		else return c;
	}
}