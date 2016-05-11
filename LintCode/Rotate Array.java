public class Solution {
    public void rotate(int[] nums, int k) {
        if  (nums.length == 0 || nums == null) return;
        k = k % nums.length;
        System.out.println(k);
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, 0, nums.length - 1);
    }
    
    private void rotate(int[] A, int start, int end) {
        for (int i = start, j = end; i <= j; i++, j--) {
            swap(A, i, j);
        }
    }
    private void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}