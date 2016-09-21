public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] maxHeights = new int[heights.length + 1];
        maxHeights[0] = 0;
        for (int i = 1; i <= heights.length; i++) {
            maxHeights[i] = Math.max(maxHeights[i - 1], heights[i - 1]);
        }
        
        int area = 0, max = 0;
        for (int i = heights.length - 1;  i >=0; i--) {
            area += Math.min(max, maxHeights[i]) > heights[i] 
                ? Math.min(max, maxHeights[i]) - heights[i] : 0;
            max = Math.max(max, heights[i]);
        }
        return area;
    }
}

//method2: two ways traverse

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftWall = height[0];
        int rightWall = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        left++;
        right--;
        int sum = 0;
        while (left <= right) {
            if (leftWall < rightWall) {
                if (height[left] < leftWall) {
                    sum += leftWall - height[left];
                } else {
                    leftWall = height[left];
                }
                left++;
                
            } else {
                if (height[right] < rightWall) {
                    sum += rightWall - height[right];
                } else {
                    rightWall = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}