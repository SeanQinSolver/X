//method1 several pass
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

//method2 one pass better
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return "";
        if (b == null || b.length() == 0) return "";
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int lenA = a.length();
        int lenB = b.length();
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
        while (indexA >= 0 || indexB >= 0) {
            sum = Integer.valueOf((indexA < 0 ? '0' - '0': a.charAt(indexA) - '0')) + Integer.valueOf((indexB < 0 ? '0' - '0' : b.charAt(indexB) - '0')) + carry;
            //System.out.println(sum);
            if (sum >= 2) {
                carry = 1;
                sum = sum % 2;
            } else {
                carry = 0;
            }
            indexA--;
            indexB--;
            sb.append(sum);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}