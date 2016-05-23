//method1
public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        if (n <= 1) return 0;
        
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                array[i] |= (1 << (words[i].charAt(j) - 'a'));
            }
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((array[i] & array[j]) == 0) {
                    ans = Math.max(words[i].length() * words[j].length(), ans);
                }
            }
        }
        return ans;
    }
}

//method2

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        if (len <= 1) return 0;
        //新建二维数组表示当前word的len的对应的26个英文字母的数组
        int[][] array = new int[len][26];
        int ans = 0;
        //每一个char映射到二维数组上
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                array[i][words[i].charAt(j) - 'a']++;
            }
        }
        //每两个word看映射的相同位置k有没有重复
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    //array[i][k]和array[j][k]同时不为零代表这两个点代表的char有重复
                    if (array[i][k] != 0 && array[j][k] != 0) {
                        //System.out.println(array[i][k] + "   " + array[j][k]);
                        flag = false;
                        break;
                    }
                }
                //如果没有重复，更新这个最大长度
                if (flag) ans = Math.max(words[i].length() * words[j].length(), ans);
            }
        }
        return ans;
    }
}