import java.util.*;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, -1};
		FirstMissingPositive fmp = new FirstMissingPositive();
		int res = fmp.FMP(array);
		System.out.println(res);

	}

	// public int FMP(int[] array) {
	// 	Arrays.sort(array);
	// 	// -1, 1, 3, 4
	// 	for (int i = 0; i < array.length; i++) {
	// 		if (array[i] > 0 && i != 0 && array[i - 1] > 0) {
	// 			if (array[i] != array[i - 1] + 1) {
	// 				return array[i - 1] + 1;
	// 			}
	// 		}
	// 	}
	// 	return array[array.length - 1] + 1;
	// }

	public int FMP(int[] array) {

		for (int i = 0; i < array.length; i++) {
			while (array[i] > 0 && array[i] < array.length && array[i] != i + 1 && array[array[i] - 1] != array[i]) {
				int temp = array[array[i] - 1];
				array[array[i] - 1] = array[i];
				array[i] = temp;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] != i + 1) {
				return i + 1;
			}
		}
		return array[array.length - 1] + 1;
	}
}