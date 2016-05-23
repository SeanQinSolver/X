public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 == 0) return isPowerOfThree(n / 3);
        return false;
    }
}


public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n != 1) {
            if (n % 3 != 0) {
                break;
            } else {
                n = n / 3;
            }
        }
        return n == 1;
    }
}


public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

//I don't think it's a coincidence. (Math.log10(n) / Math.log10(3)) is indeed a double. But when n is a power of 3, (Math.log10(n) / Math.log10(3)) % 1 will be equal to 0. Although it's still a double , but it's a int in double format. That's why this solution works. I actually first tried log(n) and I noticed that log(243) gave me 4.99999... That's why I used log10() instead. But I think that's Java's problem, not this method's problem. Because ideally log(243) should give me 5.0