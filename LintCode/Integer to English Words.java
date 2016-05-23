public class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String[] units = new String[]{"", " Thousand", " Million", " Billion"};
        String res = "";
        while (num > 0) {
            int temp = num % 1000;
            if (temp > 0) res = convert(temp) + units[i] + (res.length() == 0 ? "" : " " + res);
            num /= 1000;
            i++;
        }
        return res;
    }
    
    private String convert(int num) {
        String res = "";
        String[] ten = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] hundred = {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] twenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        if (num > 0) {
            int temp = num / 100;
            if (temp > 0) res += ten[temp] + " Hundred";
            temp = num % 100;
            
            if(temp >= 10 && temp < 20) {
                if (!res.isEmpty()) res += " ";
                res += twenty[temp % 10];
                return res;
            } else if (temp >= 20) {
                temp = temp / 10;
                if (!res.isEmpty()) res += " ";
                res += hundred[temp - 1];
            }
            temp = num % 10;
            
            if (temp > 0) {
                if (!res.isEmpty()) res += " ";
                res += ten[temp];
            }
        }
        return res;
    }
    
}