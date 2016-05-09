public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }
        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}


//写法2

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return " ";
        String[] temp = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = temp.length - 1; i >= 0; i--) {
            if (!temp[i].equals("")) {
                sb.append(temp[i] + " ");
            }
        }
        String temp1 = sb.toString();
        if (temp1.length() == 0) {
            return "";
        }
        return temp1.substring(0, temp1.length() - 1);
    }
}

//method3 用stack

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        
        Stack<String> stack = new Stack<String>();
        for (String x : array) stack.push(x);
        while (!stack.isEmpty()) {
            if (!stack.peek().equals("")) {
                sb.append(stack.pop()).append(" ");
            } else {
                stack.pop();
            }
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
