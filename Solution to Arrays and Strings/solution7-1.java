public void rotate(int[][] matrix, int n) {
	if (n == 0) return;
	for (int layer = 0; layer < n / 2; layer ++) {
		firstIndex = layer;
		lastIndex = n - 1 - layer;

		for (int i = firstIndex; i <= lastIndex; i++) {
			temp = matrix[firstIndex][i];
			matrix[firstIndex][i] = matrix[lastIndex - firstIndex - i][firstIndex];
			matrix[lastIndex - firstIndex - i][firstIndex] = matrix[lastIndex][latIndex - firstIndex - i];
			matrix[lastIndex][lastIndex - firstIndex - i] = matrix[i][lastIndex];
			matrix[i][lastIndex] = temp;
		}
	}
}
/*n2 because it requires touching n2 elements*/