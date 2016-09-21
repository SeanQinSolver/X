wpublic class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public class Point {
        public int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    Comparator<Point> comparator = new Comparator<Point>(){
    public int compare(Point left, Point right) {
    return left.val - right.val;
}
};

public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return 0;
}
    if (k > matrix.length * matrix[0].length) {
    return 0;
}
    int result = bfs(matrix, k);
    return result;
}
//x row, y column
private int bfs(int[][] matrix, int k) {
    Queue<Point> heap = new PriorityQueue<Point>(k, comparator);
        for (int i = 0; i < Math.min(matrix[0].length, k); i++) {
            heap.push(new Point(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.x + 1 < matrix.length) {
                q.push(new Point(curr.x + 1, curr.y, matrix[curr.x + 1][curr.y]));
            }
        }
        return heap.peek().val;
    }
}

//此题关键是要



//method2

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    class Point {
        int x;
        int y;
        int val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    private Comparator<Point> comp = new Comparator<Point>() {
    @Override
    public int compare(Point p1, Point p2) {
    return p1.val - p2.val;
}
};

public int kthSmallest(int[][] matrix, int k) {
    if (matrix == null)  return 0;
    if (matrix.length == 0 || matrix[0].length == 0)  return 0;
    if (k > matrix.length * matrix[0].length)  return 0;
    int result = dfs(matrix, k);
    return result;
}
//x row, y column
private int dfs(int[][] matrix, int k) {
    PriorityQueue<Point> q = new PriorityQueue<Point>(k, comp);
    for (int i = 0; i < Math.min(matrix.length, k); i++) {
        q.offer(new Point(i, 0, matrix[i][0]));
}

//如果第k个小的话，也在queue的头。那么值钱queue需要poll() k - 1个出来
for (int i = 1; i < k; i++) {
    Point curr = q.poll();
    if (curr.y + 1 < matrix[0].length) {
    Point newP = new Point(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]);
    q.offer(newP);
    }
}
    return q.peek().val;

    }
}

//此题关键是已经sorted，所以不用在所有遍历。只需把第一列先放进去。在每列单独拿出一个在把相同行放进去