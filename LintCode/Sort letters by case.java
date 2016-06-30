
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

//写法3
public class Solution {
    public void sortLetters(char[] chars) {
        int pointer1 = 0;
        int pointer2 = chars.length - 1;
        
        while (pointer1 < pointer2) {
            while (pointer1 <= chars.length - 1 && Character.isLowerCase(chars[pointer1])) {
                pointer1++;
                
            }
            while (pointer2 >=0 && Character.isUpperCase(chars[pointer2])) {
                pointer2--;
                
            }
            if (pointer1 >= pointer2) break;
            exch(chars, pointer1, pointer2);
            pointer1++;
            pointer2--;
        }
    }
    private void exch(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}