class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        //空数组
        if (A.length == 0 && B.length == 0) {
            return 2.0;
        }
        
        double doProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        
        for (int i = 0; i < A.length; i++) {
            doProduct += A[i] * B[i];
            normA += Math.pow(A[i], 2);
            normB += Math.pow(B[i], 2);
        }
        if (normA == 0 && normB == 0) {
            return 2.0;
        }
        return doProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}

//此题注意double还有最后运算的分母的括号