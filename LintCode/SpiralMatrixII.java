import java.util.*;

public class SpiralMatrixII {
	

	public static void main(String[] args) {
		int n = 3;
		SpiralMatrixII spmII = new SpiralMatrixII();
		int[][] result = spmII.generateMatrix(3);
		for (int[] res : result) {
			for (int i : res) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public int[][] generateMatrix(int n) {
		if (n < 0) {
			return null;
		}

		int[][] result = new int[n][n];

		int xStart = 0;
		int yStart = 0;
		int num = 1;

		while (n > 0) {
			if (n == 1) {
				result[xStart][yStart] = num++;
				break;
			}

			for (int i = 0; i < n - 1; i++) {
				result[xStart][yStart + i] = num++;
			}

			for (int i = 0; i < n - 1; i++) {
				result[xStart + i][yStart + n - 1] = num++;
			}

			for (int i = 0; i < n - 1; i++) {
				result[xStart + n - 1][yStart + n - 1 - i] = num++;
			}

			for (int i = 0; i < n - 1; i++) {
				result[xStart + n - 1 - i][yStart] = num++;
			}

			xStart++;
			yStart++;
			n -= 2;
		}
		return result;
	}
}