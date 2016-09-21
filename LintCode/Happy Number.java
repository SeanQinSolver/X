public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        while (n != 1) {
            if (set.contains(n)) {
                System.out.println(n);
                return false;
            }
            set.add(n);
            n = helper(n);
            System.out.println(n);
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


//** 10个9一次helper计算后变成 9的平方乘以10 = 810 所以区间是在0-810
//此题思路用hashset存储已经判断的数，若无止境的话，必有重复