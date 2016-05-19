//brutal
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        
        int[] min = new int[heights.length];
        
        int maxArea = Integer.MIN_VALUE;
        
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length; j++) {
                if (i == j) {
                    min[j] = heights[j];
                } else {
                    if (heights[j] < min[j - 1]) min[j] = heights[j];
                    else min[j] = min[j - 1];
                }
                int areaTemp = min[j] * (j - i + 1);
                if (areaTemp > maxArea) maxArea = areaTemp;
            }
        }
        return maxArea;
    }
}


//method2

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int curt = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && curt <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}