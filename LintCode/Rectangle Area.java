public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (H - F) * (G - E);
        if (E >= C || F >= D || B >= H || A >= G) return sum;
        
        return sum - (Math.min(G, C) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
}

//思路：两矩形只能不重合和重合，。
//不重合的时候那么只要坐标判定>=合格就返回sum
//重合就用最小的值去判定