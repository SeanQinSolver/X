public class Solution {
    
    
    
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<String> dna = new HashSet<String>();
        
        for (int i = 0; i < s.length() - 9; i++) {
            String test = s.substring(i, i + 10);
            int encoded = encode(test);
            //System.out.println(encoded);
            if (set.contains(encoded)) {
                //System.out.println(test + "**");
                dna.add(test);
            } else {
                //System.out.println(test);
                set.add(encoded);
                //dna.add(test);
            }
        }
        
        List<String> res = new ArrayList<String>();
        for (String x : dna) {
            res.add(x);
        }
        return res;
    }
    
    //encode将会有顺序考虑在里面
    private int encode(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                sum = sum * 4;
            } else if (c == 'C') {
                sum = sum * 4 + 1;
            } else if (c == 'G') {
                sum = sum * 4 + 2;
            } else {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
}