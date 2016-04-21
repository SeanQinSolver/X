public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        
        int direction = Direction.RIGHT;
        int[] cursor = new int[]{0, 0};
        
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            result.add(matrix[cursor[0]][cursor[1]]);
            //从右，下，左，上可得到
            matrix[cursor[0]][cursor[1]] = -1;
            int[] nextCursor = Direction.move(cursor, direction);
            if (nextCursor[0] < 0 || nextCursor[0] >= matrix.length || nextCursor[1] < 0 || nextCursor[1] >= matrix[0].length || matrix[nextCursor[0]][nextCursor[1]] == -1) {
                direction = Direction.moveRight(direction);
                nextCursor = Direction.move(cursor, direction);
            }
            cursor = nextCursor;
        }
        return result;
    }
}

class Direction {
        public static int DOWN = 0;
        public static int RIGHT = 1;
        public static int LEFT = 2;
        public static int UP = 3;
    
        private static int[] dx = new int[]{1, 0, 0, -1};
        private static int[] dy = new int[]{0, 1, -1, 0};
        
        public static int moveRight(int direction) {
            if (direction == DOWN) {
                return LEFT;
            }
            else if (direction == RIGHT) {
                return DOWN;
            }
            else if (direction == LEFT) {
                return UP;
            }
            else if (direction == UP) {
                return RIGHT;
            }
            return -1;
        }
        
        public static int[] move(int[] cursor, int direction) {
            int[] nextCursor = new int[2];
            //上下
            nextCursor[0] = cursor[0] + dx[direction];
            //左右
            nextCursor[1] = cursor[1] + dy[direction];
            return nextCursor;
        }
    }


//direction: up and left -1    right and down +1