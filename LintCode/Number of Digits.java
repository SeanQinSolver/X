//method1
public class Solution {
    public int countDigitOne(int n) {
        long left = 0, right = 0, base = 1;
        int res = 0;
        if (n <= 0) return 0;
        while (n >= base) {
            left = n / base;
            right = n % base;
            
            if ((left % 10) > 1) {
                res += (left / 10 + 1) * base;
            } else if ((left % 10) == 1) {
                res += (left / 10) * base + (right + 1);
            } else {
                res += (left / 10) * base;
            }
            base *= 10;
        }
        return res;
    }
}

// 对这个数字的每一位求存在1的数字的个数。从个位开始到最高位。

// 举个例子54215，比如现在求百位上的1，54215的百位上是2。可以看到xx100到xx199的百位上都是1，这里xx从0到54，即100->199, 1100->1199...54100->54199, 这些数的百位都是1，因此百位上的1总数是55*100

// 如果n是54125,这时由于它的百位是1，先看xx100到xx199，其中xx是0到53，即54*100, 然后看54100到54125，这是26个。所以百位上的1的总数是54*100 + 26.

// 如果n是54025，那么只需要看xx100到xx199中百位上的1，这里xx从0到53，总数为54*100

// 求其他位的1的个数的方法是一样的。


//method2
public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            ones += (a + 8) / 10 * m;
            if (a % 10 == 1) ones += b + 1;
        }
        return ones;
    }
}