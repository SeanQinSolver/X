package Test;

public class Aplusb {
    
    public int aplusb(int a, int b) {
        int result  = a ^ b;
        int carry  = a & b;
        carry = carry << 1;
        if (carry != 0) {
            result = aplusb(result, carry);
        }
        return result;
    }
    public static void main(String[] args) {
        Aplusb ab = new Aplusb();
        int result = ab.aplusb(7, 14);
        System.out.println(result);
    }
}

// 先异或求得部分和，再与运算求得进位。在右移进位。
//若进位不为零，则将进位carry与上一轮result进行recursion运算