public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<String>();
        // transfer HashSet into List
        HashSet<String> set = getStringPermutation(str);
        Iterator i = set.iterator();
        while (i.hasNext()) {
            result.add((String)(i.next()));
        }
        return result;
        
    }
    
    public HashSet<String> getStringPermutation(String str) {
        HashSet<String> result = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            result.add("");
            return result;
        } else if (str.length() == 1) {
            result.add(str);
            return result;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        HashSet<String> words = getStringPermutation(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                result.add(charInsert(strNew, initial, i));
            }
        }
        return result;
    }
    
    public String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
}

//此题注意每次获取头1个，把剩下的给再次recursion.
