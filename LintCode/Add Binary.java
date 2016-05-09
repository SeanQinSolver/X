public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        int carry = 0;
        
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        
        while (lenA > 0 && lenB > 0) {
            sum = (a.charAt(lenA - 1) - '0') + (b.charAt(lenB - 1) - '0') + carry;
            carry = sum / 2;
            sb.insert(0, String.valueOf(sum % 2));
            lenA--;
            lenB--;
        }
        
        while (lenA > 0) {
            sum = a.charAt(lenA - 1) - '0' + carry;
            carry = sum / 2;
            sb.insert(0, String.valueOf(sum % 2));
            lenA--;
        }
        
        if (carry != 0) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}