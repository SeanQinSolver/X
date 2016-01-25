//method1 brutal
public boolean findElement(int[][] matrix, int elem) {
	int row = 0;
	int col = matrix[0].length - 1;
	while (row < matrix.length && col >= 0) {
		if (matrix[row][col] == elem) {
			return true;
		} else if (matrix[row][col] > elem) {
			col--;
		} else {
			row++;
		}
	}
	return false;
}

//method2 binary

public Coordinate findElement(int[][] matrix. Coordinate origin, Coordinate dest, int x) {
	if (!origin.inbounds(matrix) || !dest.inbounds(matrix)) {
		return null;
	}
	if (matrix[origin.row][origin.column] == x) {
		return origin;
	} else if (!origin.isBefore(dest)) {
		return null;
	}

	while (start.isBefore(end)) {
		p.setToAverage(start, end);
		if (x > matrix[p.row][p.column]) {
			start.row = p.row + 1;
			start.column = p.column + 1;
		} else {
			end.row = p.row - 1;
			end.column = p.column - 1;
		}
	}

	Coordinate partitionAndSearch(int[][] matrix, Coordinate origin, Coordinate dest,
		Coordinate pivot, int x) {
		Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
		Coordinate lowerLeftDest = new Coordinate(dest.row, pivot.column - 1);
		Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
		Coordinate upperRightDest = new Coordinate(pivot.row - 1, dest.column);

		Coordinate lowerLeft = findElement(matrix, lowerLeftOrigin, lowerLeftDest);
		if (lowerLeft == null) return findElement(matrix, lowerLeftOrigin, lowerLeftDest);
		return lowerLeft;
	}

	Coordinate findElement(int[][] matrix, int x) {
		Coordinate origin = new Coordinate(0, 0);
		Coordinate dest = new Coordinate(matrix.length - 1, matrix[0].length - 1);
		return findElement(matrix, origin, dest, x);
	}

	class Coordinate implements Cloneable {
		public int row, column;
		public Coordinate(int r, int c) {
			row = r;
			column = c;
		}

		public boolean inbounds(int[][] matrix) {
			return row >=0 && column >=0 && row < matrix.length && column < matrix[0].length;
		}

		public boolean isBefore(Coordinate p) {
			return row <= p.row && column < p.column;
		}
		public Object clone() {
			return new Coordinate(row, column);
		}
		public void setToAverage(Coordinate min, Coordinate max) {
			row = (min.row + max.row) / 2;
			column = (min.column + max.column) / 2;
		}
	}

}