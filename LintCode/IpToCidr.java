import java.util.*;

public class IpToCidr {
	public static void main(String[] args) {
		String input = "255.0.0.7";
		int n = 10;
		IpToCidr itc = new IpToCidr();
		List<String> res = itc.parse(input, n);
		for (String r : res) {
			System.out.print(r + " ");
		}
		System.out.println("finish");
	}

	private List<String> parse(String ip, int n) {
		int num = convertToInt(ip); 
		
		

		ArrayList<String> res = new ArrayList<>();

		while (n > 0) {
			int trailingZeros = Integer.numberOfTrailingZeros(num);
			int maxBits = 1 << trailingZeros;
			int bitValue = 1;
			int count = 0;
			while (bitValue < n && count < trailingZeros) {
				// 1000
				bitValue <<= 1;
				count++;
			}
			if (bitValue > n) {
				bitValue >>= 1;
				count--;
			}
			res.add(convertToString(num, count));
			n -= bitValue;
			num += bitValue;
		}
		return res;
	}

	private String convertToString(int num, int count) {
		final int WORD_SIZE = 8;
		String s = "";
		for (int i = 3; i >= 0; i--) {
			// 255 -> 11111111
			s += String.valueOf((num >> i * WORD_SIZE) & 255);
			s += ".";
		}
		s = s.substring(0, s.length() - 1);
		s += "/";
		s += String.valueOf(32 - count);
		return s;
	}

	private int convertToInt(String ip) {
		String[] array = ip.split("\\.");
		int res = 0;
		for (int i = 0; i <= array.length - 1; i++) {
			res *= 256;
			res += Integer.parseInt(array[i]);
		}
		return res;
	}
}


// 10 -> 3




// 255.0.0.7  n = 10;

// -> 11111111 00000000 00000000 00000111   -> 255.0.0.7/29


//

// 1 10 11 100 101 110 111 1000 1001 1010

// 1 10 100 1000 10000


// sum = 0 
// sum += 255;
// sum *= 255 * 256;
// sum += 255 * 256
