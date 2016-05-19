public class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        return Math.max(robsub(nums, 0, nums.length-2), robsub(nums, 1, nums.length-1));
    }
    
    private int robsub(int[] nums, int s, int e) {
        int n = e - s + 1;
        int[] d =new int[n];
        d[0] = nums[s];
        d[1] = Math.max(nums[s], nums[s+1]);
        
        for(int i=2; i<n; i++) {
            //注意nums[s+i]
            d[i] = Math.max(d[i-2]+nums[s+i], d[i-1]);
        }
        return d[n-1];
    }
}

//method2

public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        return Math.max(robber(nums, 0, nums.length -2), robber(nums, 1, nums.length - 1));
    }
    
    private int robber(int[] nums, int start, int end) {
        int[] rst = new int[2];
        
        if (start == end) return nums[start]
            if (start + 1 == end) return Math.max(nums[start], nums[end]);
        
        rst[start % 2] = nums[start];
        rst[(start + 1) % 2] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = start + 2; i <= end; i++) {
            rst[i % 2] = Math.max(rst[(i - 1) % 2], rst[(i - 2) % 2] + nums[i]);
        }
        return rst[end % 2];
    }
}