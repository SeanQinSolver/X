//dp1

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        int[] steps = new int[A.length];
        steps[0] = 0;
        
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[A.length - 1];
    }
}

//大牛算法, 只有这个算法能通过leetcode,神！

http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html

public class Solution {
    public int jump(int[] A) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > last) {
                last = curr;
                ret++;
            }
            curr = Math.max(curr, i + A[i]);
        }
        return ret;
    }
}
//http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html

//greed1 from bottom to top

class Solution {
public:
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    int jump(vector<int> A) {
        if (A.empty()) {
            return 0;
        }
        
        const int N = A.size() - 1;
        int jumps = 0, end = N, min_index = N;
        
        while (end > 0) {
            for (int i = end - 1; i >= 0; --i) {
                if (i + A[i] >= end) {
                    min_index = i;
                }
            }
            
            if (min_index < end) {
                ++jumps;
                end = min_index;
            } else {
                // cannot jump to the end
                return -1;
            }
        }
        
        return jumps;
    }
};


//greed2 from top to bottom c++

class Solution {
public:
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    int jump(vector<int> A) {
        if (A.empty()) {
            return 0;
        }
        
        const int N = A.size() - 1;
        int start = 0, end = 0, jumps = 0;
        
        while (end < N) {
            int farthest = end;
            for (int i = start; i <= end; ++i) {
                if (i + A[i] >= farthest) {
                    farthest = i + A[i];
                }
            }
            
            if (end < farthest) {
                ++jumps;
                start = end + 1;
                end = farthest;
            } else {
                // cannot jump to the end
                return -1;
            }
        }
        
        return jumps;
    }
};


java:

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null) return 0;
        
        int len = A.length - 1;
        int start = 0;
        int end = 0;
        int jumps = 0;
        
        while (end < len) {
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (i + A[i] >= farthest) {
                    farthest = i + A[i];
                }
            }
            
            if (end < farthest) {
                jumps++;
                start = end + 1;
                end = farthest;
            } else {
                return -1;
            }
        }
        return jumps;
    }
}

