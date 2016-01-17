
//Method1 two for loops
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] <= 'z' && chars[i] >= 'a') break;
                if (chars[i] <= 'Z' && chars[i] >= 'A' && chars[j] >= 'a'
                && chars[j] <= 'z') {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
    }
}

//Method2 one loops 

public class Solution {
    public void sortLetters(char[] chars) {
       int i = 0, j = chars.length - 1;
       char temp;
       while (i <= j) {
            while (i <= j && Character.isLowerCase(chars[i])) i++;
            while (i <= j && Character.isUpperCase(chars[j])) j--;
            // the i <= j is important cuz last step corner case. otherwise the last step
            //will do wrong things.
            if (i <= j) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++; j--;
            }           
        }
    }
}