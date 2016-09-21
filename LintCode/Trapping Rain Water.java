public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] maxHeights = new int[heights.length];
        maxHeights[0] = 0;
        for (int i = 1; i < heights.length; i++) {
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

//注意此题的意思是一前一后指针：前：maxHeight 后: max去看是否行程凹型


//method2 two pointers

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int sum = 0;
        int left = 1;
        int right = height.length - 2;
        int leftBound = height[0];
        int rightBound = height[height.length - 1];
        
        while (left <= right) {
            if (leftBound < rightBound) {
                if (height[left] < leftBound) {
                    sum += leftBound - height[left];
                } else {
                    leftBound = height[left];
                }
                left++;
            } else {
                if (height[right] < rightBound) {
                    sum += rightBound - height[right];
                } else {
                    rightBound = height[right];
                }
                right--;
            }
        }
        return sum;
    }
}