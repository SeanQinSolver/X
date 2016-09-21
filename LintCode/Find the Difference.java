//method1 loop
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        
        for (int i = 0; i < s.length(); i++) {
            if (array1[i] != array2[i]) {
                return array2[i];
            }
        }
        return array2[array2.length - 1];
    }
}

//method2 hashmap one case does not pass

public class Solution {
    public char findTheDifference(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < array1.length; i++) {
            map.put(i, array1[i]);
        }
        for (int i = 0; i < array1.length; i++) {
            if (map.get(i) != array2[i]) {
                return array2[i];
            }
        }
        return array2[array2.length - 1];
    }
}