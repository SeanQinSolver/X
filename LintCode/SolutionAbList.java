import java.util.*;

class SolutionAbList {
  public static void main(String[] args) {
    SolutionAbList sol = new SolutionAbList();
    int ans = sol.computeLongestChain();
    System.out.println(ans);
  }
  public int computeLongestChain() {
    int res = 1;
    HashSet<Long> seenNumbers = new HashSet<Long>();
    HashMap<Long, Integer> numToLenMap = new HashMap<Long, Integer>();
    for (long num = 2l; num < 100000l; num++) {
      int seqLen = getSequenceLength(num, seenNumbers, numToLenMap);
      res = Math.max(res, seqLen);
    }
    return res;
  }
  public int getSequenceLength(long startValue, HashSet<Long> seenNumbers, HashMap<Long, Integer> numToLenMap) {
    if(seenNumbers.contains(startValue)) {
      return -1;
    }
    int len = 1, delta = 0;
    long num = startValue;
    Stack<Long> stk = new Stack<Long>();
    while(num != 1) {
      delta++;
      if(!seenNumbers.contains(num)) {
        seenNumbers.add(num);
      }
      if (numToLenMap.containsKey(num)) {
        return numToLenMap.get(num) + delta;
      }
      stk.push(num);
      if(num % 2 == 1) {
        num = num * 3 + 1;
      } else {
        num /= 2;
      }
    }
    while(!stk.isEmpty()) {
      numToLenMap.put(stk.pop(), len++);
    }
    return len;
  }
}