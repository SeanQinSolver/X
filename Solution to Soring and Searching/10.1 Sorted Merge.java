public class Solution {
	public void merge(int[] a, int[] b, int lastA, int lastB) {
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int indexMerge = lastB + lastA - 1;

		while (indexB >= 0) {
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerge] = a[indexA];
				indexA--;
			} else {
				a[indexMerge] = b[indexB];
				indexB--;
			}
			indexMerge--;
		}
	}
}