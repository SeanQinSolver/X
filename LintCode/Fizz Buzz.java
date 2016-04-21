class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<String>();
        int i = 1;
        while (i <= n) {
            if (i % 15 == 0) {
                result.add("fizz buzz");
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else if (i % 3 == 0) {
                result.add("fizz");
            } else {
                result.add(i + "");
            }
            i++;
        }
        return result;
    }
}



//2 MOD


class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<String>();
        int count = 1;
        while (count <= n) {
            String temp = helper(count);
            if (temp != null) {
                result.add(temp);
            } else {
                result.add(String.valueOf(count));
            }
            count++;
        }
        return result;
    }
    
    private String helper(int n) {
        int k = 0;
        if (n % 3 == 0) k += 1;
        if (n % 5 == 0) k += 2;
        switch(k) {
            case 0:
                return null;
            case 1:
                return "fizz";
            case 2:
                return "buzz";
            case 3:
                
                return "fizz buzz";
            default:
                return null;
        }
    }
}

//此题的重点两次%
