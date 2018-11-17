import java.util.*;

public class MultiplyString {

	public static void main(String[] args) {
		String num1 = "123";
		String num2 = "456";

		MultiplyString ms = new MultiplyString();
		String res = ms.multiply(num1, num2);
		System.out.println(res);
	}

	public String multiply(String num1, String num2) {
    	
		int factor = 1;
    	Queue<Integer> queue = new LinkedList<>();
    	for (int i = num2.length() - 1; i >= 0; i--) {
    		String single = num2.charAt(i) + "";
    		int res = Integer.valueOf(process(num1, single));
    		res *= factor;
    		factor *= 10;
    		queue.offer(res);
    	}

    	int result = 0;
    	while (!queue.isEmpty()) {
    		result += queue.poll();
    	}
    	return String.valueOf(result);
    }
    private String process(String num1, String single) {
    	int addNum = 0;
    	String s = "";
    	for (int i = num1.length() - 1; i >= 0; i--) {
    		int temp = Integer.valueOf(num1.charAt(i) + "") * Integer.valueOf(single) + addNum;
    		addNum = temp / 10;
    		temp = temp % 10;
    		s = String.valueOf(temp) + s;
    	}
    	return s;
    }
}


//   123
//   456
//      738
//     6150
//    49200
// 