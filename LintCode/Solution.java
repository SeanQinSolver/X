public class Solution {

	public static void main(String[] args) {
		int input = 3;
		Solution s = new Solution();
		int res = s.getNthPrime(100);
		System.out.println(res);
	}

	public int getNthPrime(int n) {
		if (n == 0) return -1;
		if (n == 1) return 2;

		int[] array = new int[n]; // 0 -> n - 1
		array[0] = 2;
		int index = 0;
		int temp = -1;

		while (index < n - 1) {
			temp = array[index] + 1;
			//System.out.println("temp: " + temp);
			while (!checkIsPrime(temp)) {
				temp++;
			}
			array[++index] = temp;
		}
		return array[n - 1];

		// nth prime = n - 1 th prime + for loop checking isPrime from n - 1
		// array[0] = 2
		// array[1] = 3
		// array[2] = 5
		// array[3] = 7
	}

	private boolean checkIsPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}


//def getNthPrime(n):                         

//"""                         
//1 => 2                         2 => 3                         3 => 5                  4 => 7  5=>11       100 => 541                         """                         pass