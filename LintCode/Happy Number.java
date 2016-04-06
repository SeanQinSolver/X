public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = helper(n);
        }
        return true;
    }
    private int helper(int n) {
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += Math.pow(temp, 2);
            n = n / 10;
        }
        return sum;
    }
}

//此题思路用hashset存储已经判断的数，若无止境的话，必有重复