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
