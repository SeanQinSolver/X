//method1
public class Solution {
    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        while (num != 0) {
            int temp = num;
            int count = 0;
            while (temp != 0) {
                count += temp & 1;
                temp >>= 1;
            }
            rst[num] = count;
            num--;
        }
        return rst;
    }
}

//method2
//由于*2的倍数的binary里面1的个数是相同的
//所以我们可以推到出来
//

public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        int pow2 = 1,before =1;
        for(int i=1;i<=num;i++){
            if (i == pow2){
                before = res[i] = 1;
                pow2 <<= 1;
            }
            else{
                res[i] = res[before] + 1;
                before += 1;
            }
        }
        return res;
    }
}

//method3
//利用倍数原则反过来推导也行 res[i] = res[i /2]  + (i & 1)
public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=1;i<=num;i++){
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
