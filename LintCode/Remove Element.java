public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    //若是C++可用VECTOR， 用两根指针，一前一后进行删除
    public int removeElement(int[] A, int elem) {
       int pointer1 = 0;
       int pointer2 = A.length - 1;
       while(pointer1 <= pointer2) {
           if (A[pointer1] == elem) {
               A[pointer1] = A[pointer2];
               pointer2--;
           } else {
               pointer1++;
           }
       }
       return pointer2 + 1;
    }
}
