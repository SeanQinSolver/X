//METHOD1 O(N2) TLE
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isPrime(int n) {
        //int m = Math.sqrt(n);
        if (n == 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//METHOD2

public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n + 2];
        //0和1都不是prime number
        notPrime[0] = notPrime[1] = true;
        
        for (int i = 2; i * i < n; i++) {
            if (!notPrime[i]) {
                int c = i * i;
                while (c < n) {
                    //这个质数的倍数相当于用i*i + 1表示
                    //所有的小于n的倍数设为true
                    notPrime[c] = true;
                    c += i;
                }
            }
        }
        //遍历找不是prime number
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}

//埃拉托斯特尼筛法
//