class Solution {
    /**
     * @return: The same instance of this class every time
     */
    private static Solution ins = null;
    public static Solution getInstance() {
        if (ins == null) {
            ins = new Solution();
        }
        return ins;
    }
};