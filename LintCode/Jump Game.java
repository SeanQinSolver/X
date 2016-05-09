//Greedy 1, bottom-up

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return true;
        
        int index_true = A.length - 1;
        for (int i = A.length - 2; i >=0; i--) {
            if (i + A[i] >= index_true) {
                index_true = i;
            }
        }
        return index_true == 0 ? true : false;
    }
}

//题意为问是否能从起始位置到达最终位置，我们首先分析到达最终位置的条件，从坐标i出发所能到达最远的位置为 f[i] = i + A[i]f[i]=i+A[i]，如果要到达最终位置，即存在某个 ii 使得f[i] \geq N - 1f[i]≥N−1, 而想到达 ii, 则又需存在某个 jj 使得 f[j] \geq i - 1f[j]≥i−1. 依此类推直到下标为0.
//以下分析形式虽为动态规划，实则贪心法！
//State: f[i] 从 ii 出发能否到达最终位置
//Function: f[j] = j + A[j] \geq if[j]=j+A[j]≥i, 状态 jj 转移到 ii, 置为true
//Initialization: 第一个为true的元素为 A.size() - 1
//Answer: 递推到第 0 个元素时，若其值为true返回true


//Greedy 2, up-bottom

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return true;
        
        int farthest = A[0];
        for (int i = 1; i <= A.length - 1; i++) {
            if ((i <= farthest) && (i + A[i] > farthest)) {
                farthest = i + A[i];
            }
        }
        return farthest >= A.length - 1 ? true : false;
    }
}


//DP 0(n2)

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return true;
        
        boolean[] can = new boolean[A.length];
        can[0] = true;
        
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (can[j] && (j + A[j] >= i)) {
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[A.length - 1];
    }
}



