
class Pair {
    int sum;
    int index;
    public Pair(int s, int i) {
        sum = s;
        index = i;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        if (len == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i-1].index - 1};
                Arrays.sort(temp);
                //因为res是减去后的边界， 所以边界要加一
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        return res;
    }
}

//写法2,sums不用intialize成nums.length + 1



class Pair {
    int sum;
    int index;
    public Pair(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}


public class Solution {
    
    
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result[0] = result[1] = 0;
            return result;
        }
        
        Pair[] pairs = new Pair[nums.length];
        int prev = nums[0];
        pairs[0] = new Pair(nums[0], 0);
        for (int i = 1;  i < nums.length; i++) {
            pairs[i] = new Pair(nums[i] + prev, i);
            prev = pairs[i].sum;
        }
        
        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        };
        
        Arrays.sort(pairs, comp);
        
        int ans = Integer.MAX_VALUE;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (ans > pairs[i].sum - pairs[i - 1].sum) {
                ans = pairs[i].sum - pairs[i - 1].sum;
                temp1 = pairs[i].index;
                temp2 = pairs[i - 1].index;
            }
        }
        
        int[] temp = new int[]{temp1, temp2};
        Arrays.sort(temp);
        result[0] = temp[0] + 1;
        result[1] = temp[1];
        return result;
    }
}

