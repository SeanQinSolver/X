
//naive method

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public long nthUglyNumber(int n) {
        if (n <= 0) return -1;
        
        int count = 1;
        long num = 1;
        while (count < n) {
            num++;
            if (isUgly(num)) {
                count++;
            }
        }
        return num;
    }
    
    private boolean isUgly(long num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
};



//method2

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public long nthUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);
        int cur = 2;
        int min1, min2, min3;
        int p1 = 0, p2 = 0, p3 = 0;
        while (uglys.size() < n) {
            while (uglys.get(p1) * 2 < cur) {
                p1++;
            }
            min1 = uglys.get(p1) * 2;
            while (uglys.get(p2) * 3 < cur) {
                p2++;
            }
            min2 = uglys.get(p2) * 3;
            while (uglys.get(p3) * 5 < cur) {
                p3++;
            }
            min3 = uglys.get(p3) * 5;
            int next = min1 < min2 ? min1 : min2;
            next = next < min3 ? next : min3;
            cur = next + 1;
            uglys.add(next);
        }
        return uglys.get(n - 1);
        
    }
};
