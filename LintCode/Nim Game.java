public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 == 0 ? false : true;
    }
}

// 当n∈[1,3]时，先手必胜。

// 当n == 4时，无论先手第一轮如何选取，下一轮都会转化为n∈[1,3]的情形，此时先手必负。

// 当n∈[5,7]时，先手必胜，先手分别通过取走[1,3]颗石头，可将状态转化为n == 4时的情形，此时后手必负。

// 当n == 8时，无论先手第一轮如何选取，下一轮都会转化为n∈[5,7]的情形，此时先手必负。
//method2 recursion stackoverflow

public class Solution {
    
    public boolean canWinNim(int n) {
        boolean[] cache = new boolean[n + 1];
        return winHelper(n, cache);
    }
    private boolean winHelper(int n, boolean[] cache) {
        if (n <= 3) {
            cache[n] = true;
            return true;
        }
        if (cache[n]) {
            return true;
        }
        boolean result = !(winHelper(n - 1, cache) && winHelper(n - 2, cache) && winHelper(n - 3, cache));
        if (result) {
            cache[n] = true;
        }
        return result;
    }
}

//method3 recursion stackoverflow

public class Solution {
    
    private int count = 1;
    public boolean canWinNim(int n) {
        if (n <= 3) {
            if (count % 2 == 0) return true;
            else return false;
        } else {
            count++;
            return canWinNim(n - 1) || canWinNim(n - 2) || canWinNim(n - 3);
        }
    }
}